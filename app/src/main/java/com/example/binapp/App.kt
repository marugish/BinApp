package com.example.binapp

import android.app.Application
import com.example.binapp.di.databaseModule
import com.example.binapp.di.networkModule
import com.example.binapp.di.repositoryModule
import com.example.binapp.di.useCaseModule
import com.example.binapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(databaseModule, networkModule, repositoryModule, useCaseModule, viewModelModule)
        }
    }

}