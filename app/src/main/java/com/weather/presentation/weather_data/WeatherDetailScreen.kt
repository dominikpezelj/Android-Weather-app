package com.weather.presentation.weather_data

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.google.accompanist.pager.rememberPagerState
import com.weather.presentation.weather_data.components.top_navigation.TopNavigation

@OptIn(ExperimentalCoilApi::class, com.google.accompanist.pager.ExperimentalPagerApi::class)
@Composable
fun WeatherDetailScreen (
    navController: NavController,
    viewModel: WeatherDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    var pagerState = rememberPagerState(pageCount = 3)

    TopNavigation(state, pagerState)

}




