package com.example.muliusapp.ui.screens.Login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffectChannel = Channel<SideEffect>(capacity = Channel.BUFFERED)
    val sideEffectFlow = _sideEffectChannel.receiveAsFlow()

    fun updateName(newName: String) {
        _uiState.update {
            _uiState.value.copy(
                name = newName
            )
        }
    }

    fun connect() {
        viewModelScope.launch {
            if (uiState.value.name.length >= 3){
                _sideEffectChannel.send(SideEffect.Connection)
            } else {
                _sideEffectChannel.send(SideEffect.ConnectionNoName)
            }
        }

    }

    sealed interface SideEffect {
        data object Connection : SideEffect
        data object ConnectionNoName: SideEffect
    }
}