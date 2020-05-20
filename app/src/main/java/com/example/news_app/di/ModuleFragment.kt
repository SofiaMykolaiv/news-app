package com.example.news_app.di

import com.example.news_app.presentation.home.HomeFragment
import org.koin.dsl.module

val fragmentModule = module {
    factory { HomeFragment() }
}