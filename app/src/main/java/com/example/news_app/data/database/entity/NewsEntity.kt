package com.example.news_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TABLE_NEWS")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true) val id: Long? = 0L,
    @ColumnInfo(name = "status") val status: String? = "",
    @ColumnInfo(name = "totalResults") val totalResults: Int? = 0,
    @ColumnInfo(name = "articles") val articles: List<ArticleEntity>? = arrayListOf()
)