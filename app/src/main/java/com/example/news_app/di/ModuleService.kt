package com.example.news_app.di

import com.example.news_app.data.network.retrofit.service.NewsService
import com.example.news_app.data.network.retrofit.service.SearchNewsService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {
    single { get<Retrofit>().create(NewsService::class.java) }
    single { get<Retrofit>().create(SearchNewsService::class.java) }
}