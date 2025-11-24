package com.example.binapp.navigation

sealed class Screen(
    val route: String
) {
    data object Main: Screen(ROUTE_MAIN)
    data object History: Screen(ROUTE_HISTORY)

    companion object {
        const val ROUTE_MAIN = "main"
        const val ROUTE_HISTORY = "profile"
    }
}