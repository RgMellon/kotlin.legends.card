package com.example.card_legends.repositories

import com.example.card_legends.model.Mvp
import retrofit2.http.GET

interface MvpRepository {
    @GET("/best/rates")
    suspend fun getAllRates(): List<Mvp>
}