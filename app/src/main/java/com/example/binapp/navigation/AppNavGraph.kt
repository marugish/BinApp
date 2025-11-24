package com.example.binapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.binapp.presentation.lookup.MainScreen

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    historyScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Main.route
    ) {
        composable(Screen.Main.route) {
            MainScreen(navController = navHostController)
        }

        composable(Screen.History.route) {
            historyScreenContent()
        }

    }
}