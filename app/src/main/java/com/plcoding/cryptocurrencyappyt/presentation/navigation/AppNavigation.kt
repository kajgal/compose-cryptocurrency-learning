package com.plcoding.cryptocurrencyappyt.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.presentation.screens.AppScreens
import com.plcoding.cryptocurrencyappyt.presentation.screens.details.DetailsScreen
import com.plcoding.cryptocurrencyappyt.presentation.screens.home.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.name
    ) {

        composable(AppScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(AppScreens.DetailsScreen.name + "/{coinId}") {
            DetailsScreen()
        }
    }
}