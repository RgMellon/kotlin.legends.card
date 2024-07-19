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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.card_legends.ui.theme.Purple100
import com.example.card_legends.ui.theme.Purple200
import com.example.card_legends.ui.theme.Yellow
import com.example.card_legends.ui.viewModel.PlayerProfileViewModel
import me.bytebeats.views.charts.bar.BarChart
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.bar.SimpleBarDrawer
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerProfileScreen(viewModel: PlayerProfileViewModel, navController: NavController) {
    val profileState by viewModel.uiState.collectAsState();

    Scaffold(
        topBar = {
            TopAppBar(
                contentColor = Color.White,
                backgroundColor = Yellow,
                title = {
                    Text("")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Purple100)
                .padding(innerPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Yellow)
            ) {
                Box(
                    modifier = Modifier
                        .offset(y = 40.dp)
                        .clip(RoundedCornerShape(120.dp))
                        .width(100.dp)
                        .height(100.dp)
                        .border(
                            width = 2.dp,
                            color = Purple200,
                            shape = RoundedCornerShape(100.dp)
                        )
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(profileState.profile?.photo)
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
                Text(
                    text = "${profileState.profile?.nickName} ",
                    color = Color.White,
                    fontSize = 18.sp
                )

                Row(
                    modifier = Modifier.padding(0.dp, 17.dp),
                    horizontalArrangement = Arrangement.spacedBy(17.dp)
                ) {
                    Text(
                        text = "Min : ${profileState.profile?.minRate}",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Média : ${profileState.profile?.maxRate}",
                        color = Yellow,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "Max : ${profileState.profile?.averageRate}",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }


                Column(modifier = Modifier.padding(0.dp, 50.dp)) {

                    val barChartData = profileState.profile?.rates?.map {
                        BarChartData.Bar(label = "", value = it.rate, color = Yellow)
                    }?.let {
                        BarChartData(
                            bars = it
                        )
                    }



                    if (barChartData != null) {
                        BarChart(
                            barChartData = barChartData,
                            modifier = Modifier.height(240.dp),
                            barDrawer = SimpleBarDrawer(),
                            xAxisDrawer = SimpleXAxisDrawer(),
                            labelDrawer = SimpleLabelDrawer(),
                            yAxisDrawer = SimpleYAxisDrawer()

                        )
                    }
                }

            }
        }
    }

}