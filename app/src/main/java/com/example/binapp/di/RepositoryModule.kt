package com.example.binapp.di

import com.example.binapp.domain.database.LocalDbRepository
import com.example.binapp.data.database.LocalDbRepositoryImpl
import com.example.binapp.data.sharing.ExternalNavigatorImpl
import com.example.binapp.domain.external.ExternalNavigator
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    single<LocalDbRepository> {
        LocalDbRepositoryImpl(
            binDao = get(),
            dbMapper = get()
        )
    }
    single<ExternalNavigator> {
        ExternalNavigatorImpl(context = androidContext())
    }

}