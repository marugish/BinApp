package com.example.binapp.presentation.lookup

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.binapp.R

@Composable
fun ShowProgress() {
    CircularProgressIndicator(
        color = colorResource(R.color.pink),
        strokeWidth = 4.dp,
        modifier = Modifier.size(48.dp),
        progress = { 0.7f },
        strokeCap = StrokeCap.Round
    )
}