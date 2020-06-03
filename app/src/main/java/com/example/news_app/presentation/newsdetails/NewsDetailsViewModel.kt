package com.example.news_app.presentation.newsdetails

import androidx.lifecycle.MutableLiveData
import com.example.news_app.data.repository.FavouriteRepository
import com.example.news_app.data.repository.NewsDetailsRepository
import com.example.news_app.presentation.base.BaseViewModel
import com.example.news_app.presentation.model.ArticleModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class NewsDetailsViewModel : BaseViewModel() {

    private val newsDetailsRepository by inject<NewsDetailsRepository>()
    private val favouriteRepository by inject<FavouriteRepository>()

    val newsDetailsLiveData = MutableLiveData<ArticleModel>()
    val favouriteLiveData = MutableLiveData<Boolean>()

    fun getArticleFromDatabase(title: String?) = CoroutineScope(Dispatchers.IO).launch {
        try {
            if (title != null) {
                loadingLiveData.postValue(true)
                val articleModel = newsDetailsRepository.getNewsDetailsFromDatabase(title)
                newsDetailsLiveData.postValue(articleModel)
            } else {
                errorMessageLiveData.postValue("Null article id")
            }
        } catch (e: Exception) {
            errorMessageLiveData.postValue(e.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }

    fun setIsFavourite(title: String?) = CoroutineScope(Dispatchers.IO).launch {
        try {
            if (title != null) {
                loadingLiveData.postValue(true)
                val isFavourite = favouriteRepository.setIsFavourite(title)
                favouriteLiveData.postValue(isFavourite)
            } else {
                errorMessageLiveData.postValue("Null article id")
            }
        } catch (e: Exception) {
            errorMessageLiveData.postValue(e.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }
}