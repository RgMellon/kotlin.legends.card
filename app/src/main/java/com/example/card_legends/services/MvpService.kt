package com.example.card_legends.services

import android.util.Log
import com.example.card_legends.model.Mvp
import com.example.card_legends.repositories.MvpRepository
import java.net.ConnectException
import javax.inject.Inject

class MvpService @Inject constructor(
    private  val mvpRepository: MvpRepository
){
    suspend fun getMvps(): List<Mvp> {
        try {
            return mvpRepository.getAllRates();
        } catch (err: ConnectException) {
            Log.e("getAllRates", "Falha ao recuperar os mvps")
            throw err;
        }
    }
}