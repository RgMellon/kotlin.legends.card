package com.example.card_legends.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.card_legends.services.MvpService
import com.example.card_legends.ui.states.MvpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MvpViewModel @Inject constructor(
    private val mvpService: MvpService
): ViewModel() {
    private  var onLoadMvpsJob: Job? = null;

    private val _uiState: MutableStateFlow<MvpState> = MutableStateFlow(MvpState())

    val uiState = _uiState.asStateFlow()

    init {
        onLoad()
    }

    private  fun onLoad() {
        onLoadMvpsJob?.cancel()
        onLoadMvpsJob = viewModelScope.launch{
            try {
                val mvpResponse = mvpService.getMvps();
                Timber.i("mvpResponsee2 %s", mvpResponse)
                _uiState.value = _uiState.value.copy(mvps = mvpResponse)
            } catch (err: Exception) {
                Log.i("ONLOAD METHOD", "onLoad: fail $err")
            }
        }
    }

}