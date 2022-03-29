package com.weather.data.repository

import com.weather.data.remote.DataInterface
import com.weather.data.remote.dto.WeatherDataDto
import com.weather.domain.repository.WeatherRepo
import javax.inject.Inject

class WeatherRepoImplementation @Inject constructor(
    private val api: DataInterface
) : WeatherRepo {
    override suspend fun getData(
        key: String,
        q: String,
        days: Int,
        aqi: String,
        alerts: String
    ): WeatherDataDto {
        return api.getData(key, q,days,aqi,alerts)
    }
}