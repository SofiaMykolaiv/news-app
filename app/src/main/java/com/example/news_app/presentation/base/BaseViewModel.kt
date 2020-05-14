package com.example.news_app.presentation.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.koin.core.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent, LifecycleObserver {
    val errorMessageLiveData = MutableLiveData<String>()
    val loadingLiveData = MutableLiveData<Boolean>()
}