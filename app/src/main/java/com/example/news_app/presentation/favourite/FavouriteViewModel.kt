package com.example.news_app.presentation.favourite

import androidx.lifecycle.MutableLiveData
import com.example.news_app.data.repository.FavouriteRepository
import com.example.news_app.presentation.base.BaseViewModel
import com.example.news_app.presentation.model.FavouriteModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.inject

class FavouriteViewModel() : BaseViewModel() {

    private val favouriteRepository by inject<FavouriteRepository>()

    val favouriteLiveData = MutableLiveData<List<FavouriteModel>>()

    fun loadFavouriteListDatabase() = CoroutineScope(Dispatchers.IO).launch {
        try {
            loadingLiveData.postValue(true)
            val response = favouriteRepository.loadFavouriteListDatabase()
            favouriteLiveData.postValue(response)
        } catch (exception: Exception) {
            errorMessageLiveData.postValue(exception.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }
}