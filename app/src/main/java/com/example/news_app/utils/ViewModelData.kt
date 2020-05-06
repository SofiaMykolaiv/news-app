package com.example.news_app.utils

data class ViewModelData<V, E : Exception>(val data: V? = null, val error: E? = null) {
    companion object {
        fun <V, E : Exception, P> error(error: E) = ViewModelData<V, E>(null, error)
    }
}