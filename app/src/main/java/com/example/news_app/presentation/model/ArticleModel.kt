package com.example.news_app.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticleModel(
    var author: String? = "",
    var title: String? = "",
    var description: String? = "",
    var urlToImage: String? = "",
    var urlToWebsite: String? = "",
    var publishedAt: String? = "",
    var content: String? = "",
    var isFavourite: Boolean? = false
) : Parcelable
