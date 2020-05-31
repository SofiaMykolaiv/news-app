package com.example.news_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TABLE_ARTICLE")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "author") var author: String? = "",
    @ColumnInfo(name = "title") var title: String? = "",
    @ColumnInfo(name = "description") var description: String? = "",
    @ColumnInfo(name = "urlToImage") var urlToImage: String? = "",
    @ColumnInfo(name = "url") var urlToWebsite: String? = "",
    @ColumnInfo(name = "publishedAt") var publishedAt: String? = "",
    @ColumnInfo(name = "content") var content: String? = "",
    @ColumnInfo(name = "isFavourite") var isFavourite: Boolean? = false
)