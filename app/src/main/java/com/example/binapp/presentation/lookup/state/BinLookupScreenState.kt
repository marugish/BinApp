package com.example.binapp.presentation.lookup.state

import com.example.binapp.domain.model.Bin

sealed class BinLookupScreenState {
    data object Initial: BinLookupScreenState()
    data object Loading: BinLookupScreenState()
    data class Content(val binInfo: Bin): BinLookupScreenState()
    data class Error(val errorMessage: String, val errorCode: Int): BinLookupScreenState()
}