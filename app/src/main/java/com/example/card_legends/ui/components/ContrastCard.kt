package com.example.card_legends.ui.components

import android.graphics.drawable.shapes.Shape
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.card_legends.model.Player
import com.example.card_legends.ui.theme.Purple100
import com.example.card_legends.ui.theme.Purple200
import com.example.card_legends.ui.theme.Yellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContrastCard(player: Player, modifier: Modifier = Modifier, navController: NavController) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        onClick = {
            navController.navigate("playerProfile/${player.id}")
        },
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(200.dp)
            .height(250.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .background(Purple100)
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(80.dp))
                    .width(90.dp)
                    .height(90.dp)
                    .padding(1.dp)
                    .border(
                        width = 1.dp,
                        color = Yellow,
                        shape = RoundedCornerShape(50.dp)
                    )
            ) {
                AsyncImage(
                    modifier = modifier.fillMaxSize(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(player.photo)
                        .crossfade(true)
                        .scale(Scale.FIT)
                        .build(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }

            Text(
                modifier = Modifier.padding(0.dp, 10.dp),
                text = player.nickName,
                color = Color.White,
                fontSize = 18.sp
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(modifier = Modifier.width(20.dp)) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://raw.communitydragon.org/latest/plugins/rcp-fe-lol-clash/global/default/assets/images/position-selector/positions/icon-position-bottom.png")
                            .crossfade(true)
                            .build(),
                        contentDescription = null
                    )
                }
                Text(
                    modifier = Modifier.padding(4.dp, 0.dp),
                    text = player.role,
                    color = Color.White,
                    fontSize = 14.sp
                )
            }

            Text(
                modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp),
                text = "Nota ${player.rate}",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}