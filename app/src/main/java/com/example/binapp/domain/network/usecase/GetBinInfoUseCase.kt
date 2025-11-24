package com.example.binapp.domain.network.usecase

import com.example.binapp.domain.network.NetworkRepository
import com.example.binapp.domain.network.state.BinResource
import kotlinx.coroutines.flow.Flow

class GetBinInfoUseCase(private val networkRepository: NetworkRepository) {
    operator fun invoke(query: String): Flow<BinResource> {
        return networkRepository.getBinInfo(query = query)
    }
}