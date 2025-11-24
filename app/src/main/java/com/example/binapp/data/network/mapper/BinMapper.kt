package com.example.binapp.data.network.mapper

import com.example.binapp.data.network.dto.BankDto
import com.example.binapp.data.network.dto.BinInfoDto
import com.example.binapp.data.network.dto.CountryDto
import com.example.binapp.domain.model.Bank
import com.example.binapp.domain.model.Bin
import com.example.binapp.domain.model.Country

object BinMapper {
    fun mapToDomain(binInfoDto: BinInfoDto, bin: String): Bin {
        return Bin(
            name = bin,
            scheme = binInfoDto.scheme,
            type = binInfoDto.type,
            brand = binInfoDto.brand,
            country = binInfoDto.country.toDomain(),
            bank = binInfoDto.bank.toDomain()
        )
    }

    private fun CountryDto.toDomain() = Country(
        name = this.name,
        emoji = this.emoji,
        latitude = this.latitude,
        longitude = this.longitude
    )

    private fun BankDto.toDomain() = Bank(
        name = this.name ?: "",
        url = this.url ?: "",
        phone = this.phone ?: "",
        city = this.city ?: ""
    )
}