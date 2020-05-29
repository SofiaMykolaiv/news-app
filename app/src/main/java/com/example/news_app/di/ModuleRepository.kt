package com.example.news_app.di

import com.example.news_app.data.repository.FavouriteRepository
import com.example.news_app.data.repository.HomeRepository
import com.example.news_app.data.repository.SearchRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { HomeRepository() }
    single { SearchRepository() }
    single { FavouriteRepository() }
}