package com.example.news_app.presentation.home

import androidx.lifecycle.MutableLiveData
import com.example.news_app.data.repository.HomeRepository
import com.example.news_app.presentation.base.BaseViewModel
import com.example.news_app.presentation.model.ArticleModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class HomeViewModel : BaseViewModel() {

    private val homeRepository by inject<HomeRepository>()

    val articleLiveData = MutableLiveData<List<ArticleModel>>()

    fun getArticleList() = CoroutineScope(Dispatchers.IO).launch {
        try {
            loadingLiveData.postValue(true)
            val articleList = homeRepository.loadArticleListNetwork()
            articleLiveData.postValue(articleList)
        } catch (e: Exception) {
            errorMessageLiveData.postValue(e.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }
}