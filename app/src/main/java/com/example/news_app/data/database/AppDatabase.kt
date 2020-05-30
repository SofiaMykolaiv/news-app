package com.example.news_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.news_app.data.database.dao.ArticleDao
import com.example.news_app.data.database.dao.NewsDao
import com.example.news_app.data.database.entity.ArticleEntity
import com.example.news_app.data.database.entity.NewsEntity

@Database(
    entities = [
        (NewsEntity::class),
        (ArticleEntity::class)
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
    abstract fun newsDao(): NewsDao
}