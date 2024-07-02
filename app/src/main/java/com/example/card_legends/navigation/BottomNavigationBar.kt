package com.example.card_legends.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.card_legends.ui.theme.Purple100
import com.example.card_legends.ui.theme.Purple200

@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(
        contentColor = Color.White,
        backgroundColor = Purple200,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Purple100,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        var selectedScreen by remember { mutableStateOf(Screens.Home.route) }


        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = null) },
            label = { Text("Home") },
            selected = currentRoute === selectedScreen,
            onClick = {
                selectedScreen = Screens.Home.route
                navController.navigate(Screens.Home.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

        BottomNavigationItem(
            icon = { Icon(Icons.Filled.Star, contentDescription = null) },
            label = { Text("Mvp") },
            selected = currentRoute === Screens.RankPlayers.route,
            onClick = {
                selectedScreen = Screens.RankPlayers.route
                navController.navigate(Screens.RankPlayers.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )

//        BottomNavigationItem(
//            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = null) },
//            label = { Text("Perfil") },
//            selected = currentRoute === Screens.PlayerProfile.route,
//            onClick = {
//                selectedScreen = Screens.PlayerProfile.route
//                navController.navigate(Screens.PlayerProfile.route) {
//                    popUpTo(navController.graph.findStartDestination().id) {
//                        saveState = true
//                    }
//                    launchSingleTop = true
//                    restoreState = true
//                }
//            }
//        )
    }
}