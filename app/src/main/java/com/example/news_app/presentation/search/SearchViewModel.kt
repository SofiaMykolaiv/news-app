package com.example.news_app.presentation.search

import androidx.lifecycle.MutableLiveData
import com.example.news_app.data.repository.SearchRepository
import com.example.news_app.presentation.base.BaseViewModel
import com.example.news_app.presentation.model.SearchArticleModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class SearchViewModel() : BaseViewModel() {

    private val searchRepository by inject<SearchRepository>()

    val searchArticleLiveData = MutableLiveData<List<SearchArticleModel>>()

    fun getSearchArticleList(searchField: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            loadingLiveData.postValue(true)
            val searchArticleList = searchRepository.loadSearchNewsListNetwork(searchText = searchField)
            searchArticleLiveData.postValue(searchArticleList)
        } catch (e: Exception) {
            errorMessageLiveData.postValue(e.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }
}