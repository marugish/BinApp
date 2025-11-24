package com.example.binapp.domain.external.usecase

import com.example.binapp.domain.external.ExternalNavigator

class OpenPhoneUseCase(private val externalNavigator: ExternalNavigator) {
    operator fun invoke(phone: String) {
        externalNavigator.openPhone(phone = phone)
    }
}