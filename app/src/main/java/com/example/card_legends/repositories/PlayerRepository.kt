package com.example.card_legends.repositories

import com.example.card_legends.model.TeamWithPlayers
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayerRepository {
    @GET("players/team/v2")
    suspend fun getAllPlayers(@Query("stageId") stageId: String): List<TeamWithPlayers>
}