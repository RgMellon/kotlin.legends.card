package com.example.card_legends.repositories

import com.example.card_legends.model.Stage
import com.example.card_legends.model.StageResponse
import retrofit2.http.GET
interface StageRepository {
    @GET("stages")
    suspend fun getAllStages(): StageResponse
}
