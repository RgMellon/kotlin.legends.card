package com.example.card_legends.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.card_legends.model.Player
import com.example.card_legends.ui.components.ContrastCard
import com.example.card_legends.ui.viewModel.MvpViewModel
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RankedAllPlayersScreen(viewModel: MvpViewModel, navController: NavHostController) {
    val mvpState by viewModel.uiState.collectAsState();

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.padding(10.dp, 20.dp),
            fontSize = 20.sp,
            color = Color.White,
            text = "Melhores Jogadores por posição"
        )

        LazyColumn(
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            items(mvpState.mvps) { item ->
                Text(
                    modifier = Modifier.padding(10.dp),
                    fontSize = 18.sp,
                    color = Color.White,
                    text = item.role
                )

                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(item.players) { player ->

                        ContrastCard(
                            Player(
                                role = player.role,
                                id = player.id,
                                rate = player.totalRate.toString(),
                                nickName = player.nickName,
                                photo = player.photo
                            ),
                            modifier = Modifier,
                            navController

                        )
                    }
                }

            }
        }
    }
}