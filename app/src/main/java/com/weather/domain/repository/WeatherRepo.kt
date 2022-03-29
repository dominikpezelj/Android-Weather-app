package com.weather.domain.repository

import com.weather.data.remote.dto.WeatherDataDto

interface WeatherRepo {

    suspend fun getData(key: String, q: String, days: Int, aqi: String, alerts: String ): WeatherDataDto
}