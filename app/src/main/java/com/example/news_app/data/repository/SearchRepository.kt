package com.example.news_app.data.repository

import com.example.news_app.data.mapper.mapResponseToModel
import com.example.news_app.data.network.retrofit.service.SearchNewsService
import com.example.news_app.presentation.model.SearchArticleModel
import org.koin.core.inject

class SearchRepository : BaseRepository {

    private val searchNewsService by inject<SearchNewsService>()

    suspend fun loadSearchNewsListNetwork(searchText: String): List<SearchArticleModel> {
        val searchNewsResponse = searchNewsService.loadSearchList(query = searchText)
        val searchArticleList = mapResponseToModel(searchNewsResponse.articles!!)
        return searchArticleList
    }
}