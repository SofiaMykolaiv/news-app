package com.example.news_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TABLE_ARTICLE")
data class ArticleEntity(
    @PrimaryKey(autoGenerate = true) val id: Long? = 0L,
    @ColumnInfo(name = "author") val author: String? = "",
    @ColumnInfo(name = "title") val title: String? = "",
    @ColumnInfo(name = "description") val description: String? = "",
    @ColumnInfo(name = "urlToImage") val urlToImage: String? = "",
    @ColumnInfo(name = "url") val urlToWebsite: String? = "",
    @ColumnInfo(name = "publishedAt") val publishedAt: String? = "",
    @ColumnInfo(name = "content") val content: String? = ""
)