package com.example.binapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.binapp.navigation.AppNavGraph
import com.example.binapp.presentation.history.HistoryScreen
import com.example.binapp.ui.theme.BinAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BinAppTheme {
                val navController = rememberNavController()
                AppNavGraph(
                    navHostController = navController,
                    historyScreenContent = { HistoryScreen(navController = navController) }
                )
            }
        }
    }
}



