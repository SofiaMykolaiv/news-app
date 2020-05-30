package com.example.news_app.di

import com.example.news_app.presentation.favourite.FavouriteViewModel
import com.example.news_app.presentation.home.HomeViewModel
import com.example.news_app.presentation.newsdetails.NewsDetailsViewModel
import com.example.news_app.presentation.search.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel() }
    viewModel { SearchViewModel() }
    viewModel { FavouriteViewModel() }
    viewModel { NewsDetailsViewModel() }
}