package com.example.card_legends.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.card_legends.ui.components.ContrastCard
import com.example.card_legends.ui.components.DropDownStage
import com.example.card_legends.ui.viewModel.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavController) {

    val homeState by viewModel.uiState.collectAsState();

    if (homeState.isLoad) {
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                Modifier.align(Alignment.Center)
            )
        }
    } else {
        Column(modifier = Modifier.padding(15.dp)) {
            Box(
                modifier = Modifier.wrapContentSize(Alignment.TopStart)
            ) {
                DropDownStage(
                    homeState.allStages,
                    getBestPlayersOfTheWeek = { stageId ->
                        viewModel.getBestPlayersOfTheWeek(stageId)
                    },
                    getAllPlayers = { stageId ->
                        viewModel.getPlayers(stageId)
                    }
                )
            }

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
                    ContrastCard(it.player, modifier = Modifier, navController)
                }
            }

            Text(
                modifier = Modifier.padding(10.dp, 10.dp, 0.dp),
                fontSize = 18.sp,
                color = Color.White,
                text = "Todos Jogadores"
            )


            LazyColumn(
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                items(homeState.allPlayers) { item ->
                    Text(
                        modifier = Modifier.padding(10.dp),
                        fontSize = 18.sp,
                        color = Color.White,
                        text = item.teamName
                    )

                    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        items(item.players) { player ->
                            Column(
                                Modifier
                                    .width(80.dp)
                                    .height(160.dp)

                            ) {

                                Column(
                                    Modifier
                                        .width(80.dp)
                                        .height(60.dp)
                                ) {
                                    AsyncImage(
                                        modifier = Modifier
                                            .size(80.dp)
                                            .clip(RoundedCornerShape(8.dp)),
                                        model = ImageRequest.Builder(LocalContext.current)
                                            .data(player.photo)
                                            .crossfade(true)
                                            .scale(Scale.FIT)
                                            .build(),
                                        contentDescription = player.nickName,
                                        contentScale = ContentScale.Crop
                                    )
                                }


                                Column(modifier = Modifier.padding(0.dp, 10.dp)) {
                                    Text(
                                        text = player.nickName,
                                        color = Color.White,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold
                                    )


                                    Text(
                                        modifier = Modifier.padding(0.dp, 5.dp),
                                        text = player.role,
                                        color = Color.LightGray,
                                        fontSize = 12.sp,
                                    )

                                    Text(
                                        modifier = Modifier.padding(0.dp, 5.dp),
                                        text = "Nota : ${player.rate}",
                                        color = Color.LightGray,
                                        fontSize = 12.sp,
                                    )

                                }
                            }
                        }
                    }
                }
            }
        }
    }
}