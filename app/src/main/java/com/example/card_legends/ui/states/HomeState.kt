package com.example.card_legends.ui.states

import com.example.card_legends.model.BestPlayersOfWeek
import com.example.card_legends.model.Player
import com.example.card_legends.model.Stage
import com.example.card_legends.model.TeamWithPlayers

data class HomeState(
    val bestPlayersOfWeek: List<BestPlayersOfWeek> = emptyList(),
    val isLoad: Boolean = true,
    val isLoadPlayer: Boolean = true,
    val allPlayers: List<TeamWithPlayers> = emptyList(),
    val allStages: List<Stage> = emptyList()
)