package com.example.binapp.domain.database.usecase

import com.example.binapp.domain.database.LocalDbRepository
import com.example.binapp.domain.model.Bin

class InsertBinIntoDbUseCase(private val repository: LocalDbRepository) {
    suspend operator fun invoke(bin: Bin) {
        repository.insertBin(bin = bin)
    }
}