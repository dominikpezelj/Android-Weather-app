package com.weather.presentation.weather_data.components.top_navigation.handler

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.weather.common.Constants

class ColorHandler {
    @Composable
    fun getNO2Color(no2Value: Double): Color {
        var no2Color = Color.White
        when (no2Value) {
            in 0.0..67.0 -> no2Color = Color(Constants.POLL_COL_LOW_FIRST)
            in 68.0..134.0 -> no2Color = Color(Constants.POLL_COL_LOW_SECOND)
            in 135.0..200.0 -> no2Color = Color(Constants.POLL_COL_LOW_THIRD)
            in 201.0..267.0 -> no2Color = Color(Constants.POLL_COL_MODERATE_FIRST)
            in 268.0..334.0 -> no2Color = Color(Constants.POLL_COL_MODERATE_SECOND)
            in 335.0..400.0 -> no2Color = Color(Constants.POLL_COL_MODERATE_THIRD)
            in 401.0..467.0 -> no2Color = Color(Constants.POLL_COL_HIGH_FIRST)
            in 468.0..534.0 -> no2Color = Color(Constants.POLL_COL_HIGH_SECOND)
            in 535.0..600.0 -> no2Color = Color(Constants.POLL_COL_HIGH_THIRD)
            in 601.0..2500.0 -> no2Color = Color(Constants.POLL_COL_VERYHIGH)

        }
        return no2Color
    }

    @Composable
    fun getO3Color(o3Value: Double): Color {
        var o3Color = Color.White
        when (o3Value) {
            in 0.0..33.0 -> o3Color = Color(Constants.POLL_COL_LOW_FIRST)
            in 34.0..66.0 -> o3Color = Color(Constants.POLL_COL_LOW_SECOND)
            in 67.0..100.0 -> o3Color = Color(Constants.POLL_COL_LOW_THIRD)
            in 101.0..120.0 -> o3Color = Color(Constants.POLL_COL_MODERATE_FIRST)
            in 121.0..140.0 -> o3Color = Color(Constants.POLL_COL_MODERATE_SECOND)
            in 141.0..160.0 -> o3Color = Color(Constants.POLL_COL_MODERATE_THIRD)
            in 161.0..187.0 -> o3Color = Color(Constants.POLL_COL_HIGH_FIRST)
            in 188.0..213.0 -> o3Color = Color(Constants.POLL_COL_HIGH_SECOND)
            in 214.0..240.0 -> o3Color = Color(Constants.POLL_COL_HIGH_THIRD)
            in 241.0..500.0 -> o3Color = Color(Constants.POLL_COL_VERYHIGH)

        }
        return o3Color
    }

    @Composable
    fun getSO2Color(so2Value: Double): Color {
        var so2Color = Color.White
        when (so2Value) {
            in 0.0..88.0 -> so2Color = Color(Constants.POLL_COL_LOW_FIRST)
            in 89.0..177.0 -> so2Color = Color(Constants.POLL_COL_LOW_SECOND)
            in 178.0..266.0 -> so2Color = Color(Constants.POLL_COL_LOW_THIRD)
            in 267.0..354.0 -> so2Color = Color(Constants.POLL_COL_MODERATE_FIRST)
            in 355.0..443.0 -> so2Color = Color(Constants.POLL_COL_MODERATE_SECOND)
            in 444.0..532.0 -> so2Color = Color(Constants.POLL_COL_MODERATE_THIRD)
            in 533.0..710.0 -> so2Color = Color(Constants.POLL_COL_HIGH_FIRST)
            in 711.0..887.0 -> so2Color = Color(Constants.POLL_COL_HIGH_SECOND)
            in 888.0..1064.0 -> so2Color = Color(Constants.POLL_COL_HIGH_THIRD)
            in 1065.0..3000.0 -> so2Color = Color(Constants.POLL_COL_VERYHIGH)

        }
        return so2Color
    }

    @Composable
    fun getPM25Color(pm25Value: Double): Color {
        var pm25Color = Color.White
        when (pm25Value) {
            in 0.0..11.0 -> pm25Color = Color(Constants.POLL_COL_LOW_FIRST)
            in 12.0..23.0 -> pm25Color = Color(Constants.POLL_COL_LOW_SECOND)
            in 24.0..35.0 -> pm25Color = Color(Constants.POLL_COL_LOW_THIRD)
            in 36.0..41.0 -> pm25Color = Color(Constants.POLL_COL_MODERATE_FIRST)
            in 42.0..47.0 -> pm25Color = Color(Constants.POLL_COL_MODERATE_SECOND)
            in 48.0..53.0 -> pm25Color = Color(Constants.POLL_COL_MODERATE_THIRD)
            in 54.0..58.0 -> pm25Color = Color(Constants.POLL_COL_HIGH_FIRST)
            in 59.0..64.0 -> pm25Color = Color(Constants.POLL_COL_HIGH_SECOND)
            in 65.0..71.0 -> pm25Color = Color(Constants.POLL_COL_HIGH_THIRD)
            in 72.0..3000.0 -> pm25Color = Color(Constants.POLL_COL_VERYHIGH)

        }
        return pm25Color
    }

    @Composable
    fun getPM10Color(pm10Value: Int): Color {
        var pm10Color = Color.White
        when (pm10Value) {
            in 0..16 -> pm10Color = Color(Constants.POLL_COL_LOW_FIRST)
            in 17..33 -> pm10Color = Color(Constants.POLL_COL_LOW_SECOND)
            in 34..50 -> pm10Color = Color(Constants.POLL_COL_LOW_THIRD)
            in 51..58 -> pm10Color = Color(Constants.POLL_COL_MODERATE_FIRST)
            in 59..66 -> pm10Color = Color(Constants.POLL_COL_MODERATE_SECOND)
            in 67..75 -> pm10Color = Color(Constants.POLL_COL_MODERATE_THIRD)
            in 76..83 -> pm10Color = Color(Constants.POLL_COL_HIGH_FIRST)
            in 84..91 -> pm10Color = Color(Constants.POLL_COL_HIGH_SECOND)
            in 92..100 -> pm10Color = Color(Constants.POLL_COL_HIGH_THIRD)
            in 101..3000 -> pm10Color = Color(Constants.POLL_COL_VERYHIGH)

        }
        return pm10Color
    }

    @Composable
    fun getDEFRAColor(defraValue: Int): Color {
        var defraColor = Color.White
        when (defraValue) {
            1, 2, 3 -> defraColor = Color(Constants.DEFRA_COL_LOW)
            4, 5, 6 -> defraColor = Color(Constants.DEFRA_COL_MODERATE)
            7, 8, 9 -> defraColor = Color(Constants.DEFRA_COL_HIGH)
            10 -> defraColor = Color(Constants.DEFRA_COL_VERYHIGH)

        }
        return defraColor
    }
}