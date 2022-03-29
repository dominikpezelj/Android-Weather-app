package com.weather.presentation.weather_data.components.top_navigation.top_navigation_screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.weather.common.Constants
import com.weather.domain.use_case.get_current_location.GetCurrentLocationUseCase
import com.weather.presentation.weather_data.WeatherDetailState
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ScreenForecast(state: WeatherDetailState) {
    val date = Calendar.getInstance().time
    val dateFormat = SimpleDateFormat("dd.MM.yyyy - HH:mm")
    val newDate = dateFormat.format(date)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(Constants.COL_SECONDARY_DARK))
    ) {

        state.weather?.let { weather ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {

                item {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = rememberImagePainter("https:" + weather.current.condition.icon),
                            contentDescription = null,
                            modifier = Modifier.size(64.dp)
                        )

                        Text(
                            text = " ${weather.forecast.forecastday[0].astro.moon_phase} \n",

                            )


                        val context = LocalContext.current
                        GetCurrentLocationUseCase().getFineLocation()

                        //Toast.makeText(context, "Test2: " + GetCurrentLocationUseCase().getFineLocation(), Toast.LENGTH_LONG).show()
                    }
                    Divider()

                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error

            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}