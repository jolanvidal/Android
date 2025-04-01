package com.example.muliusapp.models

import androidx.compose.ui.graphics.painter.Painter
import com.example.muliusapp.ui.navigation.Destination

data class App(
    val title: String,
    val icon: Painter,
    val destination: () -> Unit
)