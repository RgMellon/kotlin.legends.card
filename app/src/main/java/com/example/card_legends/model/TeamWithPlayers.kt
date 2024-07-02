package com.example.card_legends.model

data class TeamWithPlayers(
    val teamName: String,
    val id: String,
    val logo: String,
    val players: List<Player> = emptyList()
)