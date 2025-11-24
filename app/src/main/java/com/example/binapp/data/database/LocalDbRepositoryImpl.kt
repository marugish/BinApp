package com.example.binapp.data.database

import com.example.binapp.data.database.dao.BinDao
import com.example.binapp.data.database.mapper.DbMapper
import com.example.binapp.domain.database.LocalDbRepository
import com.example.binapp.domain.model.Bin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDbRepositoryImpl(
    private val binDao: BinDao,
    private val dbMapper: DbMapper
): LocalDbRepository {

    override suspend fun insertBin(bin: Bin) {
        binDao.insertBin(bin = dbMapper.mapToDbEntity(bin = bin))
    }

    override fun getBins(): Flow<List<Bin>> {
        return binDao.getBins().map { dbEntities ->
            dbMapper.mapListDbEntityToDomainList(dbEntities)
        }
    }
}