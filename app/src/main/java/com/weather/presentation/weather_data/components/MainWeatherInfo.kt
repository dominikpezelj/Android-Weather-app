package com.weather.presentation.weather_data.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.weather.domain.model.Weather



@Composable
fun MainWeatherInfo (
    weather: Weather,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(
            text = weather.current.feelslike_c.toString(),
            style= MaterialTheme.typography.h3
        )
    }
}