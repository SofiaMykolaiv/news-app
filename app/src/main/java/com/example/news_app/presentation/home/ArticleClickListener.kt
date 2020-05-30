package com.example.news_app.presentation.home

import com.example.news_app.presentation.model.ArticleModel

interface ArticleClickListener {
    fun onItemClick(articleModel: ArticleModel)
}