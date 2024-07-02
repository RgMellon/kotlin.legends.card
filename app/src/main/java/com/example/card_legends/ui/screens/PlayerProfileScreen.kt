package com.example.card_legends.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.example.card_legends.ui.theme.Purple100
import com.example.card_legends.ui.theme.Purple200
import com.example.card_legends.ui.theme.Yellow
import me.bytebeats.views.charts.bar.BarChart
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.bar.SimpleBarDrawer
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer

@Composable
fun PlayerProfileScreen(id: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple100)
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Yellow)
        ) {
            Box(
                modifier = Modifier
                    .offset(y = 40.dp)
                    .clip(RoundedCornerShape(120.dp))
                    .width(120.dp)
                    .height(120.dp)
                    .border(
                        width = 2.dp,
                        color = Purple200,
                        shape = RoundedCornerShape(100.dp)
                    )
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://s2-ge.glbimg.com/LEt1Xnj9WJSf9wHdUiZcA4S9zGs=/0x0:1920x1280/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_bc8228b6673f488aa253bbcb03c80ec5/internal_photos/bs/2021/D/x/BhvHUrSXCcpPt2iDQi2g/ranger-flamengo-lol-cblol-2020-etapa-1-riot-games.jpg")
                        .crossfade(true)
                        .scale(Scale.FIT)
                        .build(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Ranger $id", color = Color.White, fontSize = 18.sp)

            Row(
                modifier = Modifier.padding(0.dp, 17.dp),
                horizontalArrangement = Arrangement.spacedBy(17.dp)
            ) {
                Text(text = "Min : 100", color = Color.White, fontSize = 16.sp)
                Text(text = "Média : 100", color = Yellow, fontSize = 16.sp)
                Text(text = "Max : 100", color = Color.White, fontSize = 16.sp)
            }


            Column(modifier = Modifier.padding(0.dp, 50.dp)) {
                val barChartData = BarChartData(
                    bars = listOf(
                        BarChartData.Bar(label = "", value = 10f, color = Yellow),
                        BarChartData.Bar(label = "", value = 20f, color = Yellow),
                        BarChartData.Bar(label = "", value = 10f, color = Yellow),
                        BarChartData.Bar(label = "", value = 25f, color = Yellow)
                    )
                )



                BarChart(
                    barChartData = barChartData,
                    modifier = Modifier.height(200.dp),
                    barDrawer = SimpleBarDrawer(),
                    xAxisDrawer = SimpleXAxisDrawer(),
                    labelDrawer = SimpleLabelDrawer(),
                    yAxisDrawer = SimpleYAxisDrawer()

                )
            }

        }
    }
}