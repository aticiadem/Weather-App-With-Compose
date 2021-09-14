package com.adematici.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.adematici.weatherapp.ui.theme.WeatherAppTheme
import com.adematici.weatherapp.ui.view.MainScreen
import com.adematici.weatherapp.ui.view.SplashScreen
import com.adematici.weatherapp.ui.view.WeatherScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") {
            SplashScreen(navController)
        }
        composable("main_screen") {
            MainScreen(navController)
        }
        composable(
            "weather_screen/{city}",
            arguments = listOf(
                navArgument("city") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            WeatherScreen(
                navController,
                city = backStackEntry.arguments?.getString("city")
            )
        }
    }
}