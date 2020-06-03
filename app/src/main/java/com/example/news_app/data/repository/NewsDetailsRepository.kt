package com.example.news_app.data.repository

import com.example.news_app.data.database.dao.ArticleDao
import com.example.news_app.data.mapper.mapEntityToModel
import com.example.news_app.presentation.model.ArticleModel
import org.koin.core.inject

class NewsDetailsRepository : BaseRepository {

    private val articleDao by inject<ArticleDao>()

    suspend fun getNewsDetailsFromDatabase(title: String): ArticleModel {
        val articleEntity = articleDao.getArticle(title)
        val articleModel = mapEntityToModel(articleEntity)
        return articleModel
    }
}