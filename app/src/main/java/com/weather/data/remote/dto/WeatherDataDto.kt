package com.weather.data.remote.dto

import com.weather.domain.model.Weather

data class WeatherDataDto(
    val alerts: Alerts,
    val current: Current,
    val forecast: Forecast,
    val location: Location
)

fun WeatherDataDto.toWeather(): Weather {
    return Weather(alerts = alerts, current = current, forecast = forecast, location = location)
}