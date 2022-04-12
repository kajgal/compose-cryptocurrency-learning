package com.plcoding.cryptocurrencyappyt.presentation.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.plcoding.cryptocurrencyappyt.presentation.screens.details.components.CoinTag
import com.plcoding.cryptocurrencyappyt.presentation.screens.details.components.TeamListItem

@Composable
fun DetailsScreen(
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val state = detailsViewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        state.coin?.let { coin ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier
                                .weight(8f)
                        )
                        Text(
                            text = if (coin.isActive) "active" else "inactive",
                            color = if (coin.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.body2,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2f)
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2
                    )

                    Spacer(modifier = Modifier.height(15.dp))
                    
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h3
                    )
                    
                    Spacer(modifier = Modifier.height(15.dp))
                    
                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp
                    ) {
                        coin.tags.forEach { tag ->
                            CoinTag(tag)
                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Team members",
                        style = MaterialTheme.typography.h3
                    )
                }
                items(coin.team) { teamMember ->
                    TeamListItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        teamMember = teamMember
                    )
                    Divider()
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center),
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}