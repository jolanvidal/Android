package com.example.muliusapp.ui.screens.NumberGenerator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NumberGeneratorViewModel(application: Application): AndroidViewModel(application)
{
    private val _uiState = MutableStateFlow(NumberGeneratorUiState())
    val uiState = _uiState.asStateFlow()

    fun minValueChange(newValue: String) {
        _uiState.update {
            it.copy(
                minValue = newValue.toInt()
            )
        }
    }
}
