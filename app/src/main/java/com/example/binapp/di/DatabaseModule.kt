package com.example.binapp.di

import androidx.room.Room
import com.example.binapp.data.database.dao.BinDao
import com.example.binapp.data.database.mapper.DbMapper
import com.example.binapp.data.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    // Database
    single<AppDatabase> {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "database.db").build()
    }
    // DAO
    single<BinDao> {
        get<AppDatabase>().binDao()
    }
    // Database Mapper
    single {
        DbMapper
    }
}