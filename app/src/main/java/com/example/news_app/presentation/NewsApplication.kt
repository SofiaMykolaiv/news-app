package com.example.news_app.presentation

import android.app.Application
import com.example.news_app.di.*
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class NewsApplication : Application() {
    companion object {
        lateinit var sInstance: NewsApplication
            private set

        val getAppInstance: NewsApplication
            get() = sInstance
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        Stetho.initializeWithDefaults(this@NewsApplication)
        Timber.plant(Timber.DebugTree())
        setKoin()
    }

    private fun setKoin() = startKoin {
        androidContext(this@NewsApplication)
        modules(
            listOf(
                fragmentModule,
                viewModelModule,
                repositoryModule,
                networkModule,
                serviceModule/*,
            databaseModule,
            daoModule*/
            )
        )
    }
}