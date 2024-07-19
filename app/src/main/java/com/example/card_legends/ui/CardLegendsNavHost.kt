package com.example.card_legends.ui

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.card_legends.navigation.homeGraph
import com.example.card_legends.ui.screens.PlayerProfileScreen
import com.example.card_legends.ui.theme.Purple200
import com.example.card_legends.ui.viewModel.HomeViewModel
import com.example.card_legends.ui.viewModel.PlayerProfileViewModel

//O NavHostController é uma classe que gerencia a navegação dentro de um aplicativo Android
// . Ele é responsável por coordenar a navegação entre destinos definidos em um gráfico
// de navegação (NavGraph). Esse gráfico é geralmente especificado em um arquivo de
// recursos XML ou programaticamente.
@Composable
fun CardLegendsNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        startDestination = "main",
        navController = navController,
        modifier = modifier.background(Purple200)
    ) {
        homeGraph(navController);

        composable(
            route = "playerProfile/{profileId}",
            arguments = listOf(navArgument("profileId") { type = NavType.StringType })
        ) { backStackEntry ->
            val viewModel = hiltViewModel<PlayerProfileViewModel>()
            PlayerProfileScreen(viewModel, navController)
        }
    }
}