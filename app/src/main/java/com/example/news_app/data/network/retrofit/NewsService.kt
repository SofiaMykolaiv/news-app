package com.example.news_app.data.network.retrofit

import com.example.news_app.data.network.response.NewsResponse
import retrofit2.http.GET

interface NewsService {

    @GET("/v2/top-headlines")
    suspend fun loadNewsList(): NewsResponse
}