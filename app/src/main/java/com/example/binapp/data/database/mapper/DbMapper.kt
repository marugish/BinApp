package com.example.binapp.data.database.mapper

import com.example.binapp.data.database.entity.BankInfo
import com.example.binapp.data.database.entity.BinEntity
import com.example.binapp.data.database.entity.CountryInfo
import com.example.binapp.domain.model.Bank
import com.example.binapp.domain.model.Bin
import com.example.binapp.domain.model.Country

object DbMapper {
    // Преобразование сущности Domain-слоя в сущность Data-слоя
    fun mapToDbEntity(bin: Bin) = BinEntity(
        bin = bin.name,
        scheme = bin.scheme,
        type = bin.type,
        brand = bin.brand,
        country = bin.country.toCountryInfo(),
        bank = bin.bank.toBankInfo()
    )

    private fun Country.toCountryInfo() = CountryInfo(
        countryName = this.name,
        emoji = this.emoji,
        latitude = this.latitude,
        longitude = this.longitude
    )

    private fun Bank.toBankInfo() = BankInfo(
        bankName = this.name,
        url = this.url,
        phone = this.phone,
        city = this.city
    )

    // Преобразование сущности Data-слоя в сущность Domain-слоя
    fun mapToDomain(binEntity: BinEntity) = Bin(
        id = binEntity.binId,
        name = binEntity.bin,
        scheme = binEntity.scheme,
        type = binEntity.type,
        brand = binEntity.brand,
        country = binEntity.country.toCountry(),
        bank = binEntity.bank.toBank(),
    )

    private fun CountryInfo.toCountry() = Country(
        name = this.countryName,
        emoji = this.emoji,
        latitude = this.latitude,
        longitude = this.longitude
    )

    private fun BankInfo.toBank() = Bank(
        name = this.bankName,
        url = this.url,
        phone = this.phone,
        city = this.city
    )

    // Преобразование листов
    fun mapListDbEntityToDomainList(list: List<BinEntity>) = list.map {
        mapToDomain(it)
    }
}