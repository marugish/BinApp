package com.example.binapp.data.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bins_table")
data class BinEntity(
    @PrimaryKey(autoGenerate = true)
    val binId: Int = 0,
    val bin: String,
    val scheme: String,
    val type: String,
    val brand: String,
    @Embedded
    val country: CountryInfo,
    @Embedded
    val bank: BankInfo,
    val timestamp: Long = System.currentTimeMillis()
)

data class CountryInfo(
    val countryName: String,
    val emoji: String,
    val latitude: Int,
    val longitude: Int
)

data class BankInfo(
    val bankName: String,
    val url: String,
    val phone: String,
    val city: String
)