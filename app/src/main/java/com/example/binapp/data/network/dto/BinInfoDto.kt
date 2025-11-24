package com.example.binapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class BinInfoDto(
    @SerializedName("scheme") val scheme: String,
    @SerializedName("type") val type: String,
    @SerializedName("brand") val brand: String,
    @SerializedName("country") val country: CountryDto,
    @SerializedName("bank") val bank: BankDto,
)

data class CountryDto(
    @SerializedName("name") val name: String,
    @SerializedName("emoji") val emoji: String,
    @SerializedName("latitude") val latitude: Int,
    @SerializedName("longitude") val longitude: Int,
)

data class BankDto(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?,
    @SerializedName("phone") val phone: String?,
    @SerializedName("city") val city: String?,
)