package com.example.news_app.data.network.response

import com.google.gson.annotations.SerializedName

data class SearchNewsResponse(
    @SerializedName("status") val status: String? = "",
    @SerializedName("totalResults") val totalResults: Int? = 0,
    @SerializedName("articles") val articles: List<SearchArticleResponse>? = arrayListOf()
)