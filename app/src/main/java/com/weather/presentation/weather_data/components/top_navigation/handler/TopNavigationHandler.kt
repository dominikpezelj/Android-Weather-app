package com.weather.presentation.weather_data.components.top_navigation.handler

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.weather.presentation.weather_data.WeatherDetailState
import com.weather.presentation.weather_data.components.top_navigation.top_navigation_screens.ScreenAstronomy
import com.weather.presentation.weather_data.components.top_navigation.top_navigation_screens.ScreenCurrent
import com.weather.presentation.weather_data.components.top_navigation.top_navigation_screens.ScreenForecast


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopNavigationHandler(state: WeatherDetailState, pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,


        ) { page ->
        when (page) {
            0 -> {
                ScreenCurrent(state = state)
            }
            1 -> {
                ScreenForecast(state = state)
            }
            2 -> {
                ScreenAstronomy(state = state)
            }

        }


    }

}