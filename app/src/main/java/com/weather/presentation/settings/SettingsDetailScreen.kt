package com.weather.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.weather.common.Constants
import com.weather.presentation.weather_data.WeatherDetailViewModel

@Composable
fun SettingsDetailScreen (
    navController: NavController,
    viewModel: WeatherDetailViewModel = hiltViewModel()
) {
    Column(modifier = Modifier.fillMaxSize().background(color = Color(Constants.COL_SECONDARY_DARK))) {
        Text(text = "Settings page")
    }
}