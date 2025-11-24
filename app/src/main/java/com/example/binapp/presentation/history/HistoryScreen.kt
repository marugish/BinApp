package com.example.binapp.presentation.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.binapp.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun HistoryScreen(
    viewModel: BinHistoryViewModel = koinViewModel(),
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.history),
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        HistoryVisibility(viewModel = viewModel)
    }
}