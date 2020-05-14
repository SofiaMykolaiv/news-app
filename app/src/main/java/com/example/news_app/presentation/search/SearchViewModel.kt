package com.example.news_app.presentation.search

import androidx.lifecycle.MutableLiveData
import com.example.news_app.presentation.base.BaseViewModel

class SearchViewModel() : BaseViewModel() {

    val scoreLiveData = MutableLiveData<Int>()
    var score = 0

    fun setPositiveScoreData() {
        score += 1
        scoreLiveData.value = score
    }

    fun setNegativeScoreData() {
        score -= 1
        scoreLiveData.value = score
    }

    fun setDivideByZeroScoreData() {
        try {
            score /= 0
            scoreLiveData.value = score
        } catch (exception: Exception) {
            errorMessageLiveData.value = "fuck u"
        }
    }
}