package com.example.card_legends.model


data class PlayerProfile(
    val id: String,
    val nickName: String,
    val role: String,
    val photo: String,
    val minRate: Float,
    val maxRate: Float,
    val averageRate: Float,
    val rates: List<Rate>
)

data class Rate(
    val id: String,
    val rate: Float,
    val stage: ProfileStage
)


data class ProfileStage(
    val slug: String
)

