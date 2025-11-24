package com.example.binapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.binapp.data.database.dao.BinDao
import com.example.binapp.data.database.entity.BinEntity

@Database(version = 1, entities = [BinEntity::class], exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun binDao(): BinDao
}