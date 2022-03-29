package com.weather.domain.model

import com.weather.data.remote.dto.Alerts
import com.weather.data.remote.dto.Current
import com.weather.data.remote.dto.Forecast
import com.weather.data.remote.dto.Location

data class Weather(
    val alerts: Alerts,
    val current: Current,
    val forecast: Forecast,
    val location: Location
)
