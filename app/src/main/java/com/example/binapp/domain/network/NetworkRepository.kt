package com.example.binapp.domain.network

import com.example.binapp.domain.network.state.BinResource
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {

    fun getBinInfo(query: String): Flow<BinResource>
}