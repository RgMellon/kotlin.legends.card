package com.example.card_legends.services

import android.util.Log
import com.example.card_legends.model.Player
import com.example.card_legends.model.TeamWithPlayers
import com.example.card_legends.repositories.PlayerRepository
import java.net.ConnectException
import javax.inject.Inject

class PlayersService @Inject constructor(
    private  val playerRepository: PlayerRepository
){
    suspend fun getAllPlayers(stageId: String): List<TeamWithPlayers> {
        try {
            return  playerRepository.getAllPlayers(stageId)
        } catch (err: ConnectException) {
            Log.e("getAllPlayers", "Falha ao conectar na API", err)
            throw err
        }
    }
}