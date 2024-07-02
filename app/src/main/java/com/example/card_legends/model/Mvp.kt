package com.example.card_legends.model

data class Mvp(
    val role: String,
    val players: List<MpvPlayer>
)


data class MpvPlayer(
    val id: String,
    val nickName: String,
    val photo: String,
    val role: String,
    val totalRate: Double
)
