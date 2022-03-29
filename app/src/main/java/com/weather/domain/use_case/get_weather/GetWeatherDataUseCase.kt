package com.weather.domain.use_case.get_weather

import com.weather.common.Resource
import com.weather.data.remote.dto.toWeather
import com.weather.domain.model.Weather
import com.weather.domain.repository.WeatherRepo
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GetWeatherDataUseCase @Inject constructor(
    private val repository: WeatherRepo
){
    operator fun invoke(key: String, q: String,days: Int,aqi: String,alerts: String): kotlinx.coroutines.flow.Flow<Resource<Weather>> = flow {
        try {
            emit(Resource.Loading<Weather>())
            val weather = repository.getData(key, q, days, aqi, alerts).toWeather()
            emit(Resource.Success<Weather>(weather))
        }catch (e: HttpException){
            emit(Resource.Error<Weather>(e.localizedMessage ?: "Unexpected error occured."))
        }catch (e: IOException){
            emit(Resource.Error<Weather>("Cant reach the server!"))
        }
    }
}