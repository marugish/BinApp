package com.example.binapp.domain.model

data class Bin(
    val id: Int = 0,
    val name: String,
    val scheme: String,
    val type: String,
    val brand: String,
    val country: Country,
    val bank: Bank
)

data class Country(
    val name: String,
    val emoji: String,
    val latitude: Int,
    val longitude: Int
)

data class Bank(
    val name: String,
    val url: String,
    val phone: String,
    val city: String
)