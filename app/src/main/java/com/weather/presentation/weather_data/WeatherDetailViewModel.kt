package com.weather.presentation.weather_data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.common.Constants
import com.weather.common.Resource
import com.weather.domain.use_case.get_weather.GetWeatherDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeatherDetailViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,

) : ViewModel(){
    private val _state = mutableStateOf(WeatherDetailState())
    val state: State<WeatherDetailState> = _state


    init {

        getWeather(Constants.apiKey, "Sisak", 5,"yes", "yes")
    }

    fun getWeather(key: String, q: String,days: Int,aqi: String,alerts: String) {
        getWeatherDataUseCase(key, q, days, aqi, alerts).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = WeatherDetailState(weather = result.data)
                }
                is Resource.Error -> {
                    _state.value = WeatherDetailState(error = result.message ?: "Unknow error occured!")
                }
                is Resource.Loading -> {
                    _state.value = WeatherDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}