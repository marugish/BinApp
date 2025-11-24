package com.example.binapp.domain.database

import com.example.binapp.domain.model.Bin
import kotlinx.coroutines.flow.Flow

interface LocalDbRepository {

    suspend fun insertBin(bin: Bin)
    fun getBins(): Flow<List<Bin>>
}