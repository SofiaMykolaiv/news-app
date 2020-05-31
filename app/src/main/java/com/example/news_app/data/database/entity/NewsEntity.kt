package com.example.news_app.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "TABLE_NEWS")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true) var id: Long? = 0L,
    @ColumnInfo(name = "status") var status: String? = "",
    @ColumnInfo(name = "totalResults") var totalResults: Int? = 0,
    @Ignore var articles: List<ArticleEntity>? = arrayListOf()
)