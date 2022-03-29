package com.weather.common

import androidx.compose.ui.graphics.Color

object Constants {
    const val BASE_URL = "https://api.weatherapi.com"
    const val apiKey: String = "8ef102dbbdfd46d1abb203040211309"

    //COLORS
    const val COL_PRIMARY_DARK = 0xFF202226
    const val COL_SECONDARY_DARK = 0xFF2F3137
    const val COL_THIRD = 0xFF35383E

    const val WARNING_COLOR = 0xFFFFBF00

    //DEFRA INDEX COLOR SCALE
    const val DEFRA_COL_LOW = 0xFF31CF00
    const val DEFRA_COL_MODERATE = 0xFFFF9A00
    const val DEFRA_COL_HIGH = 0xFFFF0000
    const val DEFRA_COL_VERYHIGH = 0xFFCE30FF

    //INDEX POLLUTANT BOUNDARIES
    //LOW
    const val POLL_COL_LOW_FIRST = 0xFF9CFF9C
    const val POLL_COL_LOW_SECOND = 0xFF31FF00
    const val POLL_COL_LOW_THIRD = 0xFF31CF00
    //MODERATE
    const val POLL_COL_MODERATE_FIRST = 0xFFFFFF00
    const val POLL_COL_MODERATE_SECOND = 0xFFFFCF00
    const val POLL_COL_MODERATE_THIRD = 0xFFFF9A00
    //HIGH
    const val POLL_COL_HIGH_FIRST = 0xFFFF6464
    const val POLL_COL_HIGH_SECOND = 0xFFFF0000
    const val POLL_COL_HIGH_THIRD = 0xFF990000
    //VERY HIGH
    const val POLL_COL_VERYHIGH = 0xFFCE30FF

}