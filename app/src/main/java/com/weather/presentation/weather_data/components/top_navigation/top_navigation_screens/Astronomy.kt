package com.weather.presentation.weather_data.components.top_navigation.top_navigation_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.weather.R
import com.weather.common.Constants
import com.weather.presentation.weather_data.WeatherDetailState
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ScreenAstronomy(state: WeatherDetailState) {
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

                var imgSource = R.drawable.full_moon
                when (weather.forecast.forecastday[0].astro.moon_phase){
                    "Full Moon" -> imgSource = R.drawable.full_moon
                    "New Moon" -> imgSource = R.drawable.new_moon
                    "Waxing Crescent" -> imgSource = R.drawable.waxing_crescent
                    "First Quarter" -> imgSource = R.drawable.first_quarter
                    "Waxing Gibbous" -> imgSource = R.drawable.waxing_gibous
                    "Waning Gibbous" -> imgSource = R.drawable.waning_gibbous
                    "Last Quarter" -> imgSource = R.drawable.last_quarter
                    "Waning Crescent" -> imgSource = R.drawable.waning_crescent

                }
                item {
                    Row (
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Color(Constants.COL_PRIMARY_DARK),
                                shape = RoundedCornerShape(30.dp)
                            )
                            .height(140.dp)
                            .padding(10.dp)
                    ){
                        Image(
                            painterResource(id = imgSource),
                            contentDescription = null,
                            modifier = Modifier.size(110.dp).padding(top = 10.dp)
                        )
                        Column(modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Transparent), horizontalAlignment = Alignment.CenterHorizontally){

                            Text( text = "${weather.forecast.forecastday[0].astro.moon_phase}\n")
                        }

                    }


                    Spacer(modifier = Modifier.height(50.dp))


                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Color(Constants.COL_PRIMARY_DARK),
                            shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                        )
                        .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(text = "ASTRONOMY INFORMATION", fontSize = 15.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)


                    }
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Color(Constants.COL_THIRD),
                            shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp)
                        )
                        .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Sunrise",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier.padding(0.dp, 5.dp)
                            )
                            Text(
                                text = weather.forecast.forecastday[0].astro.sunrise,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .background(
                                        Color(Constants.COL_PRIMARY_DARK),
                                        RoundedCornerShape(5.dp)
                                    )
                                    .padding(5.dp)
                            )


                        }
                        Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Sunset",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier.padding(0.dp, 5.dp)
                            )
                            Text(
                                text = weather.forecast.forecastday[0].astro.sunset,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .background(
                                        Color(Constants.COL_PRIMARY_DARK),
                                        RoundedCornerShape(5.dp)
                                    )
                                    .padding(5.dp)
                            )


                        }

                        Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))


                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Moonrise",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier.padding(0.dp, 5.dp)
                            )
                            Text(
                                text = weather.forecast.forecastday[0].astro.moonrise,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .background(
                                        Color(Constants.COL_PRIMARY_DARK),
                                        RoundedCornerShape(5.dp)
                                    )
                                    .padding(5.dp)
                            )


                        }

                        Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Moonset",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier.padding(0.dp, 5.dp)
                            )
                            Text(
                                text = weather.forecast.forecastday[0].astro.moonset,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .background(
                                        Color(Constants.COL_PRIMARY_DARK),
                                        RoundedCornerShape(5.dp)
                                    )
                                    .padding(5.dp)
                            )


                        }

                        Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Moon illumination",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Light,
                                modifier = Modifier.padding(0.dp, 5.dp)
                            )
                            Text(
                                text = weather.forecast.forecastday[0].astro.moon_illumination +" %",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .background(
                                        Color(Constants.COL_PRIMARY_DARK),
                                        RoundedCornerShape(5.dp)
                                    )
                                    .padding(5.dp)
                            )


                        }





                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    Spacer(modifier = Modifier.height(50.dp))
                    
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