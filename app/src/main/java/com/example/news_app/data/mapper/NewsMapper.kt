package com.example.news_app.data.mapper

import com.example.news_app.data.database.entity.ArticleEntity
import com.example.news_app.data.network.response.ArticleResponse
import com.example.news_app.presentation.model.ArticleModel

fun ArticleResponse.mapResponseToModel(articleResponse: ArticleResponse) = ArticleModel(
    author = articleResponse.author,
    title = articleResponse.title,
    description = articleResponse.description,
    urlToImage = articleResponse.urlToImage,
    urlToWebsite = articleResponse.urlToWebsite,
    publishedAt = articleResponse.publishedAt,
    content = articleResponse.content
)

fun mapResponseToModel(articleList: List<ArticleResponse>) = articleList.map { articleResponse ->
    ArticleModel(
        author = articleResponse.author,
        title = articleResponse.title,
        description = articleResponse.description,
        urlToImage = articleResponse.urlToImage,
        urlToWebsite = articleResponse.urlToWebsite,
        publishedAt = articleResponse.publishedAt,
        content = articleResponse.content
    )
}

fun mapResponseToEntity(articleList: List<ArticleResponse>) = articleList.map { articleResponse ->
    ArticleEntity(
        author = articleResponse.author,
        title = articleResponse.title,
        description = articleResponse.description,
        urlToImage = articleResponse.urlToImage,
        urlToWebsite = articleResponse.urlToWebsite,
        publishedAt = articleResponse.publishedAt,
        content = articleResponse.content
    )
}

fun mapEntityToModel(articleList: List<ArticleEntity>) = articleList.map { articleEntity ->
    ArticleModel(
        author = articleEntity.author,
        title = articleEntity.title,
        description = articleEntity.description,
        urlToImage = articleEntity.urlToImage,
        urlToWebsite = articleEntity.urlToWebsite,
        publishedAt = articleEntity.publishedAt,
        content = articleEntity.content
    )
}