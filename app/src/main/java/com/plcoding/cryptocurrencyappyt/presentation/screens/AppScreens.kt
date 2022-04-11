package com.plcoding.cryptocurrencyappyt.presentation.screens

import java.lang.IllegalArgumentException

enum class AppScreens {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): AppScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Invalid route")
        }
    }
}
