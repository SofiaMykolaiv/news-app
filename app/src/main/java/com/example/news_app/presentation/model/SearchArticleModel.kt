package com.example.news_app.presentation.model

data class SearchArticleModel (
    var author: String? = "",
    var title: String? = "",
    var description: String? = "",
    var urlToImage: String? = "",
    var urlToWebsite: String? = "",
    var publishedAt: String? = "",
    var content: String? = "",
    var isFavourite: Boolean? = false
)