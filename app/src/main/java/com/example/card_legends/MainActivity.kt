package com.example.card_legends

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.card_legends.ui.screens.HomeScreen
import com.example.card_legends.ui.states.HomeState
import com.example.card_legends.ui.theme.Card_legendsTheme
import com.example.card_legends.ui.theme.Purple200
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Card_legendsTheme {
                val homeState = HomeState()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Purple200
                ) {
                    HomeScreen(modifier = Modifier.fillMaxWidth(), homeState)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Card_legendsTheme {
        HomeScreen(homeState = HomeState())
    }
}