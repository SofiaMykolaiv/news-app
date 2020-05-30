package com.example.news_app.presentation.search

import com.example.news_app.presentation.model.SearchArticleModel

interface SearchArticleClickListener {
    fun onItemClick(searchArticleModel: SearchArticleModel)
}