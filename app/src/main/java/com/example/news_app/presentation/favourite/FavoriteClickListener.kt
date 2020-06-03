package com.example.news_app.presentation.favourite

import com.example.news_app.presentation.model.FavouriteModel

interface FavoriteClickListener {
    fun onItemClick(favouriteModel: FavouriteModel)
}