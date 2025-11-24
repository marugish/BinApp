package com.example.binapp.di

import com.example.binapp.presentation.history.BinHistoryViewModel
import com.example.binapp.presentation.lookup.BinLookupViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        BinHistoryViewModel(
            getBinsFromDbUseCase = get(),
            openLinkUseCase = get(),
            openPhoneUseCase = get(),
            openMapsUseCase = get()
        )
    }
    viewModel {
        BinLookupViewModel(
            insertBinIntoDbUseCase = get(),
            getBinInfoUseCase = get(),
            openLinkUseCase = get(),
            openPhoneUseCase = get(),
            openMapsUseCase = get()
        )
    }
}