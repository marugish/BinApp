package com.example.binapp.presentation.history.state

import com.example.binapp.domain.model.Bin

sealed class BinHistoryScreenState {

    data object Loading: BinHistoryScreenState()
    data class Content(val list: List<Bin>): BinHistoryScreenState()
    data object Error: BinHistoryScreenState()
    data object Empty: BinHistoryScreenState()
}