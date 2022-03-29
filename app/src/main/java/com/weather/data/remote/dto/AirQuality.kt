package com.weather.data.remote.dto

import com.google.gson.annotations.SerializedName

data class AirQuality(
    val co: Double,
    @SerializedName("gb-defra-index")
    val gbDefraIndex: Int,
    val no2: Double,
    val o3: Double,
    val pm10: Double,
    val pm2_5: Double,
    val so2: Double,
    @SerializedName("us-epa-index")
    val usEpaIndex: Int
)