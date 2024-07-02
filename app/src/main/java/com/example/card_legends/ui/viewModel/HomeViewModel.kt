package com.example.card_legends.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.card_legends.model.BestPlayersOfWeek
import com.example.card_legends.services.BestPlayerService
import com.example.card_legends.services.PlayersService
import com.example.card_legends.services.StageService
import com.example.card_legends.ui.states.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val bestPlayersService: BestPlayerService,
    private val playerService: PlayersService,
    private val stageService: StageService
) : ViewModel() {
    private var onLoadJob: Job? = null
    private var loadPlayersJob: Job? = null
    private var loadStageJob: Job? = null

    private val _uiState: MutableStateFlow<HomeState> = MutableStateFlow(HomeState())

    val uiState = _uiState.asStateFlow()

    init {
        onLoad()
        loadPlayers()
        loadStage()
    }

    private fun onLoad() {
        onLoadJob?.cancel()
        onLoadJob = viewModelScope.launch {
            getBestPlayersOfTheWeek("fea24f83-c75e-415b-9188-b9886a3d2747")
        }

    }

    fun getBestPlayersOfTheWeek(stageId: String) {
        viewModelScope.launch {
            try {
                val bestPlayersOfWeek = bestPlayersService.getBestPlayersOfTheWeek(stageId);
                updateUiState(isLoad = false, bestPlayersOfWeek = bestPlayersOfWeek)
            } catch (err: Exception) {
                _uiState.value = _uiState.value.copy(isLoad = false)
                Log.i("ONLOAD METHOD", "onLoad: fail $err")
            }
        }
    }

    private fun loadPlayers() {
        loadPlayersJob?.cancel()
        getPlayers("fea24f83-c75e-415b-9188-b9886a3d2747")
        loadPlayersJob = viewModelScope.launch {

        }
    }

    fun getPlayers(stageId: String) {
        viewModelScope.launch {
            try {
                val allPlayers = playerService.getAllPlayers(stageId);
                Log.i("allPlayers", "loadPlayers: $allPlayers")
                _uiState.value = _uiState.value.copy(isLoadPlayer = true, allPlayers = allPlayers)
            } catch (err: Exception) {
                _uiState.value = _uiState.value.copy(isLoadPlayer = false)
                Log.i("ONLOAD METHOD", "onLoad: fail $err")
            }
        }
    }

    private fun loadStage() {
        loadStageJob?.cancel()

        loadStageJob = viewModelScope.launch {
            try {
                val allStages = stageService.getAllStages()
                _uiState.value = _uiState.value.copy(allStages = allStages)
            } catch (err: Exception) {
                Log.i("loadStage METHOD", "loadStage: fail $err")
            }
        }
    }

    private fun updateUiState(isLoad: Boolean, bestPlayersOfWeek: List<BestPlayersOfWeek>) {
        _uiState.value = _uiState.value.copy(isLoad = isLoad, bestPlayersOfWeek = bestPlayersOfWeek)
    }


}