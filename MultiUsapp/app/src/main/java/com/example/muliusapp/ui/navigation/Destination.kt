package com.example.muliusapp.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {

    @Serializable
    data object Login : Destination
    @Serializable
    data object MainScreen : Destination
    @Serializable
    data object NumberGenerator: Destination
}
