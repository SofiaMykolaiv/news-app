package com.example.news_app.data.repository

import com.example.news_app.data.database.dao.ArticleDao
import com.example.news_app.data.mapper.mapEntityToFavouriteModel
import com.example.news_app.data.mapper.mapEntityToModel
import com.example.news_app.presentation.model.FavouriteModel
import org.koin.core.inject

class FavouriteRepository : BaseRepository {

    private val articleDao by inject<ArticleDao>()

    suspend fun setIsFavourite(title: String) : Boolean {
        val articleEntity = articleDao.getArticle(title)

        if (articleEntity.isFavourite == true) {
            articleEntity.isFavourite = false
            articleDao.insert(articleEntity)
            return false
        } else {
            articleEntity.isFavourite = true
            articleDao.insert(articleEntity)
            return true
        }
    }

    suspend fun loadFavouriteListDatabase(): List<FavouriteModel> {
        val entityList = articleDao.getFavouriteList(true)
        val favouriteList = mapEntityToFavouriteModel(entityList)
        return favouriteList
    }
}