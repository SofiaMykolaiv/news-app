package com.example.news_app.presentation.model

import com.example.news_app.data.network.response.ArticleResponse

data class NewsModel (
    val status: String? = "",
    val totalResults: Int? = 0,
    val articles: List<ArticleResponse>? = arrayListOf()
)