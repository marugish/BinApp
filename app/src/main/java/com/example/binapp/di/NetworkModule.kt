package com.example.binapp.di

import com.example.binapp.data.network.ApiService
import com.example.binapp.data.network.NetworkRepositoryImpl
import com.example.binapp.data.network.mapper.BinMapper
import com.example.binapp.domain.network.NetworkRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    // Network
    single<ApiService> {
        Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    // Mapper
    single { BinMapper }

    single<NetworkRepository> {
        NetworkRepositoryImpl(get(), get(), androidContext())
    }
}