package com.example.binapp.domain.external.usecase

import com.example.binapp.domain.external.ExternalNavigator

class OpenLinkUseCase(private val externalNavigator: ExternalNavigator) {
    operator fun invoke(link: String) {
        externalNavigator.openLink(link = link)
    }
}