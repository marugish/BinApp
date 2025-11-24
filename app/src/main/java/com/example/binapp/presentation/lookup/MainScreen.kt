package com.example.binapp.presentation.lookup

import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.binapp.R
import com.example.binapp.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainScreen(
    viewModel: BinLookupViewModel = koinViewModel(),
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LookupCard(viewModel = viewModel)
        Text(
            text = stringResource(R.string.information),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        InfoCardVisibility(viewModel = viewModel)

        val interactionSource = remember { MutableInteractionSource() }
        TextButton(
            onClick = { navController.navigate(Screen.History.route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = colorResource(R.color.blue),
                disabledContainerColor = Color.Transparent
            ),
            elevation = ButtonDefaults.buttonElevation(0.dp),
            border = null,
            modifier = Modifier.indication(
                interactionSource = interactionSource,
                indication = null
            )
        ) {
            Text(text = stringResource(R.string.click_here))
        }
    }
}