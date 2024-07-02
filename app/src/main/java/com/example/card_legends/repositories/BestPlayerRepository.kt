package com.example.card_legends.repositories

import com.example.card_legends.model.BestPlayersOfWeek
import retrofit2.http.GET
import retrofit2.http.Query

interface BestPlayerRepository {
    @GET("rates/best")
    suspend fun getBestPlayersOfWeek(@Query("stageId") stageId: String): List<BestPlayersOfWeek>
}