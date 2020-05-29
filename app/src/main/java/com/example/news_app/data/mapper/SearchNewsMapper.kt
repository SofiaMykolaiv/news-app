package com.example.news_app.data.mapper

import com.example.news_app.data.network.response.SearchArticleResponse
import com.example.news_app.presentation.model.SearchArticleModel

fun mapResponseToModel(articleList: List<SearchArticleResponse>) =
    articleList.map { searchArticleResponse ->
        SearchArticleModel(
            author = searchArticleResponse.author,
            title = searchArticleResponse.title,
            description = searchArticleResponse.description,
            urlToImage = searchArticleResponse.urlToImage,
            urlToWebsite = searchArticleResponse.urlToWebsite,
            publishedAt = searchArticleResponse.publishedAt,
            content = searchArticleResponse.content
        )
    }