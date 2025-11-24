package com.example.binapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.binapp.data.database.entity.BinEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BinDao {

    @Insert(entity = BinEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBin(bin: BinEntity)

    @Query("SELECT * FROM bins_table ORDER BY binId DESC")
    fun getBins(): Flow<List<BinEntity>>
}