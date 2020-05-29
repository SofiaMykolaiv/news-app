package com.example.news_app.data.network.retrofit.service

import com.example.news_app.data.network.response.SearchNewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchNewsService {

    @GET("/v2/everything")
    suspend fun loadSearchList(@Query("q") query: String): SearchNewsResponse
}