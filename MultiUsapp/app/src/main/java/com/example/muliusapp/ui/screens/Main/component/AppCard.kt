package com.example.muliusapp.ui.screens.Main.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.muliusapp.models.App
import com.example.muliusapp.ui.navigation.Destination

@Composable
fun AppCard(
    app: App
){
    Card(
        modifier = Modifier.aspectRatio(1.5f),
        onClick = app.destination
        ) {
        Column(
            modifier = Modifier.aspectRatio(1.5f).padding(6.dp), verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = app.title, style = MaterialTheme.typography.bodyMedium)
            Image(
                painter = app.icon, app.title
            )
        }
    }
}