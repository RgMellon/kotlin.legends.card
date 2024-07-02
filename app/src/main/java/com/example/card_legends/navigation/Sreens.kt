package com.example.card_legends.navigation

sealed class Screens(val route: String) {
    data object Home : Screens("home")
    data object RankPlayers : Screens("rankPlayers")

    data object PlayerProfile : Screens("playerProfile")
}

