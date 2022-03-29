package com.weather.presentation.weather_data

import com.weather.domain.model.Weather

class WeatherDetailState(
    val isLoading: Boolean = false,
    val weather: Weather? = null,
    val error: String = ""
)


