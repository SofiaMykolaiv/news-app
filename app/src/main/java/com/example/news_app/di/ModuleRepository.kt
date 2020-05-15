package com.example.news_app.di

import com.example.news_app.data.repository.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { HomeRepository() }
}