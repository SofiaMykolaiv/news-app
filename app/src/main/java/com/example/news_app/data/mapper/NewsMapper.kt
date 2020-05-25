package com.example.news_app.data.mapper

import com.example.news_app.data.network.response.ArticleResponse
import com.example.news_app.data.network.response.NewsResponse
import com.example.news_app.presentation.model.ArticleModel
import com.example.news_app.presentation.model.NewsModel

//fun NewsResponse.mapResponseToModel(newsResponse: NewsResponse) = NewsModel(
//    status = newsResponse.status,
//    totalResults = newsResponse.totalResults,
//    articles = newsResponse.articles
//)

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