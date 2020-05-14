package com.example.news_app.presentation.home

import androidx.lifecycle.MutableLiveData
import com.example.news_app.presentation.base.BaseViewModel
import com.example.news_app.presentation.model.ArticleModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    val articleLiveData = MutableLiveData<List<ArticleModel>>()

    fun getArticleList() = CoroutineScope(Dispatchers.IO).launch {
        try {
            loadingLiveData.postValue(true)
//            val response = homeRepository.loadArticleList()
//            articleLiveData.postValue(response)
            val articleList = arrayListOf(
                ArticleModel(
                    author = "Green Chack",
                    title = "Forest",
                    description = "Big big big forest and green",
                    urlToImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Wiktionary_small.svg/350px-Wiktionary_small.svg.png"
                ),
                ArticleModel(
                    author = "Black Ass",
                    title = "Nigga",
                    description = "Big big big nigga and his ass",
                    urlToImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Wiktionary_small.svg/350px-Wiktionary_small.svg.png"
                ),
                ArticleModel(
                    author = "White Dick",
                    title = "Sausage",
                    description = "Big big big beef and tasty",
                    urlToImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Wiktionary_small.svg/350px-Wiktionary_small.svg.png"
                )
            )
            delay(3000)
            articleLiveData.postValue(articleList)
        } catch (e: Exception) {
            errorMessageLiveData.postValue(e.message)
        } finally {
            loadingLiveData.postValue(false)
        }
    }
}