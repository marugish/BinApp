package com.example.binapp.domain.external.usecase

import com.example.binapp.domain.external.ExternalNavigator

class OpenMapsUseCase(private val externalNavigator: ExternalNavigator) {
    operator fun invoke(latitude: Int, longitude: Int) {
        externalNavigator.openMaps(latitude = latitude, longitude = longitude)
    }
}