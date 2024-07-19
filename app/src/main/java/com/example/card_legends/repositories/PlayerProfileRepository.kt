package com.example.card_legends.repositories

import com.example.card_legends.model.PlayerProfile
import retrofit2.http.GET
import retrofit2.http.Path

interface PlayerProfileRepository {
    @GET("/profile/{profileId}")
    suspend fun getProfile(@Path("profileId") id: String): PlayerProfile
}