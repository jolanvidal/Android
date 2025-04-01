package com.example.muliusapp.ui.screens.Main

import com.example.muliusapp.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.muliusapp.models.App
import com.example.muliusapp.ui.screens.Main.component.AppCard

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
    toNumberGenerator: () -> Unit
) {
    val generators = listOf(
            App( title = "Number Generator",
                icon = painterResource(R.drawable.number_generator),
                destination = toNumberGenerator
            )
    )
    val uiState = viewModel.uiState.collectAsState().value

    LazyVerticalGrid(
        modifier = Modifier.fillMaxHeight(),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(generators) { app ->
            AppCard(app)
        }
    }
}