package com.example.binapp.presentation.lookup

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.example.binapp.R
import com.example.binapp.presentation.general.BinInfoItem
import com.example.binapp.presentation.general.ShowError
import com.example.binapp.presentation.lookup.state.BinLookupScreenState

@Composable
fun InfoCardVisibility(viewModel: BinLookupViewModel) {

    val screenState = viewModel.state.observeAsState(BinLookupScreenState.Initial)

    // Полученная информация
    when(val currentState = screenState.value) {
        is BinLookupScreenState.Content -> {
            Log.d("myTest", "${currentState.binInfo}")
            BinInfoItem(
                binInfo = currentState.binInfo,
                onLinkClick = { viewModel.onLinkClick(currentState.binInfo.bank.url) },
                onCoordinateClick = { viewModel.onCoordinatesClick(currentState.binInfo.country.latitude, currentState.binInfo.country.longitude) },
                onPhoneClick = { viewModel.onPhoneClick(currentState.binInfo.bank.phone) }
            )
        }
        is BinLookupScreenState.Error -> {
            ShowError(currentState.errorMessage, currentState.errorCode)
        }
        BinLookupScreenState.Initial -> {
            Text(
                text = stringResource(R.string.initial_bin_info),
                color = colorResource(R.color.dark_grey),
                modifier = Modifier.fillMaxWidth()
            )
        }
        BinLookupScreenState.Loading -> {
            ShowProgress()
        }
    }
}