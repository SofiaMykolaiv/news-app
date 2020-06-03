package com.example.news_app.data.repository

import com.example.news_app.data.Constants
import com.example.news_app.data.database.dao.ArticleDao
import com.example.news_app.data.mapper.mapEntityToModel
import com.example.news_app.data.mapper.mapResponseToEntity
import com.example.news_app.data.mapper.mapResponseToModel
import com.example.news_app.data.network.retrofit.service.NewsService
import com.example.news_app.presentation.model.ArticleModel
import org.koin.core.inject

class HomeRepository : BaseRepository {

    private val newsService by inject<NewsService>()
    private val articleDao by inject<ArticleDao>()

    suspend fun loadArticleListNetwork(): List<ArticleModel> {
        val newsResponse = newsService.loadNewsList(country = Constants.COUNTRY_US)
        val articleList = mapResponseToModel(newsResponse.articles!!)
        articleDao.insert(mapResponseToEntity(newsResponse.articles))
        val s = ""
        return articleList
    }

    suspend fun loadArticleListDatabase(): List<ArticleModel> {
        val articleEntityList = articleDao.getList()
        val articleModelList = mapEntityToModel(articleEntityList)
        return articleModelList
    }
}