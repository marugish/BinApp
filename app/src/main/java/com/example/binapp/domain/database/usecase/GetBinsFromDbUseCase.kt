package com.example.binapp.domain.database.usecase

import com.example.binapp.domain.database.LocalDbRepository
import com.example.binapp.domain.model.Bin
import kotlinx.coroutines.flow.Flow

class GetBinsFromDbUseCase(private val repository: LocalDbRepository) {
    operator fun invoke(): Flow<List<Bin>> {
        return repository.getBins()
    }
}