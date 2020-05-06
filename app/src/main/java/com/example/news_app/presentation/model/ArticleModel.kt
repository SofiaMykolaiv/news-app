package com.example.news_app.presentation.model

data class ArticleModel(
    val author: String? = "",
    val title: String? = "",
    val description: String? = "",
    val urlToImage: String? = "",
    val urlToWebsite: String? = "",
    val publishedAt: String? = "",
    val content: String? = ""
)
