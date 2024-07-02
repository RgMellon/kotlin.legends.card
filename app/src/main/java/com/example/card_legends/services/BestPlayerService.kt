package com.example.card_legends.services

import android.util.Log
import com.example.card_legends.model.BestPlayersOfWeek
import com.example.card_legends.repositories.BestPlayerRepository
import java.net.ConnectException
import javax.inject.Inject

class BestPlayerService @Inject constructor(
    private  val bestPlayerRepository:  BestPlayerRepository
) {
    suspend fun getBestPlayersOfTheWeek(stageId: String): List<BestPlayersOfWeek> {
        try {
            return bestPlayerRepository.getBestPlayersOfWeek(stageId)
        } catch (err: ConnectException) {
            Log.e("PlayerRepositor", "Falha ao conectar na API", err)
            throw err
        }
    }
}