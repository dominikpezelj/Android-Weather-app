package com.weather.data.remote


import com.weather.data.remote.dto.WeatherDataDto
import retrofit2.http.GET
import retrofit2.http.Query


interface DataInterface {
    @GET ("/v1/forecast.json")
    //@GET("weather?lat=35&lon=139&appid=e66c3af6d6c66efb544f6c78bb4be6ec")

   suspend fun getData(@Query("key") key: String, @Query("q") q: String, @Query("days") days: Int, @Query("aqi") aqi: String, @Query("alerts") alerts: String ): WeatherDataDto
}
