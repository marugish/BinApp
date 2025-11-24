package com.example.binapp.presentation.general

interface ExternalAppLauncher {
    fun onLinkClick(link: String)
    fun onPhoneClick(phone: String)
    fun onCoordinatesClick(latitude: Int, longitude: Int)
}