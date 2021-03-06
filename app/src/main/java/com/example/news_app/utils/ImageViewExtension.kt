package com.example.news_app.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageUrl(url: String?) {
    Glide.with(context)
        .load(url)
        .centerInside()
        .into(this)
}