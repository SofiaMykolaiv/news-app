package com.example.news_app.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// News
private const val BASE_URL_NEWS = "https://newsapi.org/"
private const val API_KEY = "f550b4a026c94a04808e9a42a3e17021"
private const val AUTHORIZATION = "Authorization"
private const val BEARER = "Bearer"

// Provide Network
private const val PROVIDE_BASE_URL = "base_url"
private const val PROVIDE_API_KEY = "api_key"
private const val PROVIDE_CONVERTER_FACTORY = "gson_converter_factory"
private const val PROVIDE_OKHTTP_CLIENT = "okhttp_client"
private const val PROVIDE_RETROFIT = "retrofit"
private const val PROVIDE_GSON = "gson"

val networkModule = module {
    single(named(PROVIDE_BASE_URL)) { BASE_URL_NEWS }
    single(named(PROVIDE_API_KEY)) { API_KEY }
    single(named(PROVIDE_GSON)) { provideGson() }
    single(named(PROVIDE_OKHTTP_CLIENT)) { provideOkHttpClient(get(named(PROVIDE_API_KEY))) }
    single(named(PROVIDE_CONVERTER_FACTORY)) { provideGsonConverterFactory(get(named(PROVIDE_GSON))) }
    single { provideRetrofit(get(named(PROVIDE_BASE_URL)), get(named(PROVIDE_CONVERTER_FACTORY)), get(named(PROVIDE_OKHTTP_CLIENT))) }
}

private fun provideGson(): Gson = GsonBuilder().create()

private fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

private fun provideOkHttpClient(apiKey: String): OkHttpClient {
    val client = OkHttpClient.Builder()
    client.addInterceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .addHeader(AUTHORIZATION, "$BEARER $apiKey")
            .build()
        chain.proceed(request)
    }
    return client.build()
}

private fun provideRetrofit(baseUrl: String, gsonConverterFactory: GsonConverterFactory, client: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(gsonConverterFactory)
        .client(client)
        .build()