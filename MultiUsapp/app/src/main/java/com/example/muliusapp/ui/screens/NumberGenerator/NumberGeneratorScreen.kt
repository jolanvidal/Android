package com.example.muliusapp.ui.screens.NumberGenerator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.muliusapp.ui.navigation.Destination

@Composable
fun NumberGeneratorScreen(
    viewModel: NumberGeneratorViewModel = viewModel()
){

    val uiState = viewModel.uiState.collectAsState().value

    Column(
        Modifier.fillMaxSize().padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Number Generator", style = MaterialTheme.typography.headlineLarge)

        Row(
            Modifier.fillMaxWidth(.8f),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            TextField(
                value = uiState.minValue,
                onValueChange = {viewModel.minValueChange(uiState.minValue)},

            )
        }
    }
}