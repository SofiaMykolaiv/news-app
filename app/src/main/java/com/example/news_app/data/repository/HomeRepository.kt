package com.example.news_app.data.repository

import com.example.news_app.data.Constants
import com.example.news_app.data.mapper.mapResponseToModel
import com.example.news_app.data.network.retrofit.service.NewsService
import com.example.news_app.presentation.model.ArticleModel
import org.koin.core.inject

class HomeRepository : BaseRepository {

    private val newsService by inject<NewsService>()

    suspend fun loadArticleListNetwork(): List<ArticleModel> {
        val newsResponse = newsService.loadNewsList(country = Constants.COUNTRY_US)
        val articleList = mapResponseToModel(newsResponse.articles!!)
        return articleList
    }
}