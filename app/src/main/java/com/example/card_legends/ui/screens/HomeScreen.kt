package com.example.card_legends.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.card_legends.ui.components.ContrastCard
import com.example.card_legends.ui.states.HomeState

val itemsList = (0..5).toList()

@Composable
fun HomeScreen(modifier: Modifier = Modifier, homeState: HomeState) {
    Column(modifier = modifier.padding(15.dp)) {
        Text(
            modifier = Modifier.padding(0.dp, 10.dp),
            fontSize = 18.sp,
            color = Color.White,
            text = "Melhores jogadores da semana"
        )

        LazyRow(
            contentPadding = PaddingValues(2.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(homeState.bestPlayersOfWeek) {
                ContrastCard()
            }
        }

    }
}