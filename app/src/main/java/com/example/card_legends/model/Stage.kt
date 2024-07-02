package com.example.card_legends.model

data class Stage(
    val id: String,
    val slug: String
)

data class StageResponse(
    val stages: List<Stage>
)