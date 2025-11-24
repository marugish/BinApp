package com.example.binapp.di

import com.example.binapp.domain.network.usecase.GetBinInfoUseCase
import com.example.binapp.domain.database.usecase.GetBinsFromDbUseCase
import com.example.binapp.domain.database.usecase.InsertBinIntoDbUseCase
import com.example.binapp.domain.external.usecase.OpenLinkUseCase
import com.example.binapp.domain.external.usecase.OpenMapsUseCase
import com.example.binapp.domain.external.usecase.OpenPhoneUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory {
        GetBinsFromDbUseCase(repository = get())
    }
    factory {
        InsertBinIntoDbUseCase(repository = get())
    }
    factory {
        GetBinInfoUseCase(networkRepository = get())
    }
    factory {
        OpenLinkUseCase(externalNavigator = get())
    }
    factory {
        OpenPhoneUseCase(externalNavigator = get())
    }
    factory {
        OpenMapsUseCase(externalNavigator = get())
    }
}