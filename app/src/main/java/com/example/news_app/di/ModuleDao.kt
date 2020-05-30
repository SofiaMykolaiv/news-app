package com.example.news_app.di

import com.example.news_app.data.database.AppDatabase
import org.koin.dsl.module

val daoModule = module {
    single { get<AppDatabase>().newsDao() }
    single { get<AppDatabase>().articleDao() }
}