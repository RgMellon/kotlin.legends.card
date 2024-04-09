package com.example.card_legends.ui.components

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.card_legends.ui.theme.Purple100
import com.example.card_legends.ui.theme.Purple200

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContrastCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        onClick = { /*TODO*/ },
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(200.dp)
            .height(250.dp)
    ) {
        Column(
            modifier
                .background(Purple100)
                .fillMaxSize()
        ) {
            Text(text = "opi")
        }
    }
}