package com.example.binapp.domain.external

interface ExternalNavigator {

    fun openLink(link: String)
    fun openPhone(phone: String)
    fun openMaps(latitude: Int, longitude: Int)
}