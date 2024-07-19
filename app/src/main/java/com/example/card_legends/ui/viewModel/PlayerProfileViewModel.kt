package com.example.card_legends.ui.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.card_legends.repositories.PlayerProfileRepository
import com.example.card_legends.ui.states.PlayerProfileState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerProfileViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,

    private val playerProfileRepository: PlayerProfileRepository
) : ViewModel() {
    private var currentUiStateJob: Job? = null

    private val _uiState = MutableStateFlow<PlayerProfileState>(PlayerProfileState())
    val uiState = _uiState.asStateFlow()

    init {
        loadUiState()
    }

    private fun loadUiState() {
        currentUiStateJob?.cancel()

        currentUiStateJob = viewModelScope.launch {
            try {
                val response = playerProfileRepository.getProfile(
                    requireNotNull(
                        savedStateHandle["profileId"]
                    )
                )

                Log.e("Profile", "Profile Respo $response");

                _uiState.value = _uiState.value.copy(profile = response)
            } catch (err: Exception) {
                Log.e("Profile", "error to load profile $err");
            }
        }
    }
}