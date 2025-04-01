package com.example.muliusapp.ui.screens.Login

import android.widget.Toast
import com.example.muliusapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel(),
    toMainScreen: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsState().value

    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current
    LaunchedEffect(viewModel.sideEffectFlow) {
        lifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.sideEffectFlow.collect { sideEffect ->
                when (sideEffect) {
                    LoginViewModel.SideEffect.Connection -> {
                        toMainScreen()
                    }
                    LoginViewModel.SideEffect.ConnectionNoName -> {
                        Toast.makeText(context, "Username must be bigger than 2 caracters", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    Scaffold() { innerPaddings ->
        Column(
           modifier = Modifier
               .fillMaxSize()
               .padding(innerPaddings),
           horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "MultiUsApp", fontSize = 50.sp, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(top = 20.dp))
            Image(
                painter = painterResource(R.drawable.logo), "Logo MultiUsapp",
                modifier = Modifier
                    .size(350.dp)
                    .padding(top = 45.dp)
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .padding(top = 35.dp),
                value = uiState.name,
                onValueChange = { newName ->
                    viewModel.updateName(newName)
                },
                label = {Text(text = "Username")}
            )
            Button(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(.5f),
                onClick = {viewModel.connect()}
            ) {
                Text(text = "Connect", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}