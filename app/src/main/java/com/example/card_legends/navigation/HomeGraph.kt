package com.example.card_legends.navigation


import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.card_legends.ui.screens.HomeScreen
import com.example.card_legends.ui.screens.PlayerProfileScreen
import com.example.card_legends.ui.screens.RankedAllPlayersScreen
import com.example.card_legends.ui.viewModel.HomeViewModel
import com.example.card_legends.ui.viewModel.MvpViewModel


fun NavGraphBuilder.homeGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screens.Home.route,
        route = "main"
    ) {
        composable(Screens.Home.route) {
            val viewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(viewModel = viewModel, navController)
        }

        composable(Screens.RankPlayers.route) {
            val viewModel = hiltViewModel<MvpViewModel>()
            RankedAllPlayersScreen(viewModel = viewModel, navController)
        }

    }
}

