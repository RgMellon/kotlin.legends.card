package com.example.card_legends.services

import android.util.Log
import com.example.card_legends.model.Stage
import com.example.card_legends.repositories.StageRepository
import java.net.ConnectException
import javax.inject.Inject

class StageService @Inject constructor(
    private val stageRepository: StageRepository
) {
    suspend fun getAllStages(): List<Stage> {
        try {
            val i = stageRepository.getAllStages().stages
            Log.i("getAllStages", "getAllStages: $i")
            return i
        } catch (err: ConnectException) {
            Log.e("getAllStages", "Falha ao conectar na API", err)
            throw err
        }
    }
}