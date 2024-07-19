package com.example.card_legends.ui.states

import com.example.card_legends.model.PlayerProfile

data class PlayerProfileState(
    val profile: PlayerProfile? = null,
    val isLoading: Boolean = false
)
