package com.plcoding.cryptocurrencyappyt.presentation.screens.home

import com.plcoding.cryptocurrencyappyt.domain.models.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
