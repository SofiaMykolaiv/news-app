package com.example.news_app.data.network.response

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    @SerializedName("author") val author: String? = "",
    @SerializedName("title") val title: String? = "",
    @SerializedName("description") val description: String? = "",
    @SerializedName("urlToImage") val urlToImage: String? = "",
    @SerializedName("url") val urlToWebsite: String? = "",
    @SerializedName("publishedAt") val publishedAt: String? = "",
    @SerializedName("content") val content: String? = ""
)