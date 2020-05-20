package com.example.news_app.data.repository

import com.example.news_app.presentation.model.FavouriteModel

class FavouriteRepository : BaseRepository {

    suspend fun loadFavouriteListNetwork(): List<FavouriteModel> {
        return arrayListOf()
    }
}