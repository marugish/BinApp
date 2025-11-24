package com.example.binapp.presentation.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.example.binapp.presentation.general.BinInfoItem
import com.example.binapp.presentation.general.ShowError
import com.example.binapp.presentation.history.state.BinHistoryScreenState
import com.example.binapp.presentation.lookup.ShowProgress

@Composable
fun HistoryVisibility(viewModel: BinHistoryViewModel) {
    val screenState = viewModel.state.observeAsState(BinHistoryScreenState.Loading)
    when(val currentState = screenState.value) {
        is BinHistoryScreenState.Content -> {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = currentState.list, key = { it.id }) { binInfo ->
                    BinInfoItem(
                        binInfo = binInfo,
                        onLinkClick = { viewModel.onLinkClick(binInfo.bank.url) },
                        onCoordinateClick = {
                            viewModel.onCoordinatesClick(
                                binInfo.country.latitude,
                                binInfo.country.longitude
                            )
                        },
                        onPhoneClick = { viewModel.onPhoneClick(binInfo.bank.phone) }
                    )
                }
            }
        }
        BinHistoryScreenState.Error -> {
            ShowError("Error with Database", 0)
        }
        BinHistoryScreenState.Loading -> {
            ShowProgress()
        }
        BinHistoryScreenState.Empty -> {
            ShowEmptyDatabase()
        }
    }
}