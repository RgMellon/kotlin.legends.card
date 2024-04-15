package com.example.card_legends.ui.states

import com.example.card_legends.model.BestPlayersOfWeek
import com.example.card_legends.model.Player

val mockPlayer = Player(
    "10239",
    "Titan",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGXpXEKBaHu8BD609JDkePV5Nadwv4twdnKCWYJXjpWg&s",
    "ADC",
    "99",
)


val mock: List<BestPlayersOfWeek> = listOf(
    BestPlayersOfWeek(
        rate = 89,
        id = "1230210",
        stageId = "0213903219",
        player = mockPlayer
    ),
    BestPlayersOfWeek(
        rate = 90,
        id = "1233fdsf121",
        stageId = "12391230dk",
        player = mockPlayer
    ),
)

data class HomeState(
    val bestPlayersOfWeek: List<BestPlayersOfWeek> = mock
)