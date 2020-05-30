package com.example.news_app.di

import androidx.room.Room
import com.example.news_app.data.database.AppDatabase
import com.example.news_app.presentation.NewsApplication
import org.koin.dsl.module

private const val DATABASE_NAME = "News-Database"

val databaseModule = module {
    single { provideDatabase() }
}

private fun provideDatabase(): AppDatabase =
    Room.databaseBuilder(NewsApplication.getAppInstance, AppDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()