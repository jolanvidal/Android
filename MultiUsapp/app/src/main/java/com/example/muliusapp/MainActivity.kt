package com.example.muliusapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.muliusapp.ui.navigation.Destination
import com.example.muliusapp.ui.screens.Login.LoginScreen
import com.example.muliusapp.ui.screens.Main.MainScreen
import com.example.muliusapp.ui.screens.NumberGenerator.NumberGeneratorScreen
import com.example.muliusapp.ui.theme.MuliUsappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MuliUsappTheme {
                Scaffold() { innerPaddings ->
                    val navController = rememberNavController()
                    NavHost(
                        modifier = Modifier.fillMaxSize().padding(innerPaddings),
                        navController = navController,
                        startDestination = Destination.Login
                    ) {
                        composable<Destination.Login> {
                            LoginScreen(
                                toMainScreen = {navController.navigate(Destination.MainScreen)}
                            )
                        }
                        composable<Destination.MainScreen> {
                            MainScreen(
                                toNumberGenerator = {navController.navigate(Destination.NumberGenerator)}
                            )
                        }
                        composable<Destination.NumberGenerator> {
                            NumberGeneratorScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MuliUsappTheme {
        Greeting("Android")
    }
}