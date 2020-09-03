package com.example.moviemvvmapp.backend

import android.app.Application
import com.example.moviemvvmapp.activities.main.di.movieModule
import com.example.moviemvvmapp.di.picassoModule
import com.example.moviemvvmapp.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyCustomApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyCustomApp)
            modules(listOf(retrofitModule, picassoModule, movieModule))
        }
    }
}