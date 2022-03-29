package com.weather.di


import com.weather.common.Constants
import com.weather.data.remote.DataInterface
import com.weather.data.repository.WeatherRepoImplementation
import com.weather.domain.repository.WeatherRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideWeatherApi(): DataInterface {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepo(api: DataInterface): WeatherRepo {
        return WeatherRepoImplementation(api)
    }
}