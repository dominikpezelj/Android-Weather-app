package com.weather.presentation.main_menu.main_bottom_navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.weather.presentation.BottomNavItem
import com.weather.presentation.compass.CompassDetailScreen
import com.weather.presentation.settings.SettingsDetailScreen
import com.weather.presentation.timezones.TimezonesDetailScreen
import com.weather.presentation.weather_data.WeatherDetailScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Forecast.screen_route) {
        composable(BottomNavItem.Forecast.screen_route) {
            WeatherDetailScreen(navController = navController)
        }
        composable(BottomNavItem.Timezones.screen_route) {
            TimezonesDetailScreen(navController = navController)
        }
        composable(BottomNavItem.Compass.screen_route) {
            CompassDetailScreen(navController = navController)
        }
        composable(BottomNavItem.Settings.screen_route) {
            SettingsDetailScreen(navController = navController)
        }


    }
}