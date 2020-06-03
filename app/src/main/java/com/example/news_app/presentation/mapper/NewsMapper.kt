package com.example.news_app.presentation.mapper

import com.example.news_app.presentation.model.ArticleModel
import com.example.news_app.presentation.model.FavouriteModel
import com.example.news_app.presentation.model.SearchArticleModel

fun mapSearchToArticleModel(searchArticleModel: SearchArticleModel) = ArticleModel(
    author = searchArticleModel.author,
    title = searchArticleModel.title,
    description = searchArticleModel.description,
    urlToImage = searchArticleModel.urlToImage,
    urlToWebsite = searchArticleModel.urlToWebsite,
    publishedAt = searchArticleModel.publishedAt,
    content = searchArticleModel.content
)
fun mapFavouriteToArticleModel(favouriteModel: FavouriteModel) = ArticleModel(
    author = favouriteModel.author,
    title = favouriteModel.title,
    description = favouriteModel.description,
    urlToImage = favouriteModel.urlToImage,
    urlToWebsite = favouriteModel.urlToWebsite,
    publishedAt = favouriteModel.publishedAt,
    content = favouriteModel.content
)