package com.example.muliusapp.ui.screens.Main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.muliusapp.ui.screens.Login.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel (application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState = _uiState.asStateFlow()
}