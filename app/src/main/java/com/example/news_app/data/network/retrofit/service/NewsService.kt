package com.example.news_app.data.network.retrofit.service

import com.example.news_app.data.network.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("/v2/top-headlines")
    suspend fun loadNewsList(@Query("country") country: String): NewsResponse
}