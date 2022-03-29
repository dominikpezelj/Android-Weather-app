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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.weather.R
import com.weather.common.Constants
import com.weather.domain.use_case.get_current_location.GetCurrentLocationUseCase
import com.weather.presentation.weather_data.WeatherDetailState
import com.weather.presentation.weather_data.components.top_navigation.handler.ColorHandler
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ScreenCurrent(state: WeatherDetailState) {
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
                val currentWeatherIcon = weather.current.condition.icon
                val oldValue = "64x64"
                val newValue = "128x128"
                val newWeatherIcon = currentWeatherIcon.replace(
                    oldValue = oldValue,
                    newValue = newValue,
                    ignoreCase = true
                )

                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Color(Constants.COL_PRIMARY_DARK),
                                    shape = RoundedCornerShape(30.dp)
                                )
                                .height(140.dp)
                                .padding(10.dp)
                        ) {
                            Image(
                                painter = rememberImagePainter("https:$newWeatherIcon"),
                                contentDescription = null,
                                modifier = Modifier.size(128.dp)
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color.Transparent),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "${weather.current.feelslike_c.roundToInt()} °C\n",
                                    fontSize = 36.sp,
                                    fontWeight = FontWeight.Bold
                                )

                                Text(text = "${weather.location.name},\n ${weather.location.region}\n")
                            }

                        }


                        Spacer(modifier = Modifier.height(50.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Color(Constants.COL_PRIMARY_DARK),
                                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                                )
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "WIND INFORMATION",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )


                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Color(Constants.COL_THIRD),
                                    shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp)
                                )
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Wind direction",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                var windDir = weather.current.wind_dir
                                var arrowRotation: Double = 0.0
                                when (windDir) {
                                    "N" -> arrowRotation = 270.0
                                    "NNE" -> arrowRotation = 292.5
                                    "NE" -> arrowRotation = 315.0
                                    "ENE" -> arrowRotation = 337.5
                                    "E" -> arrowRotation = 0.0
                                    "ESE" -> arrowRotation = 22.5
                                    "SE" -> arrowRotation = 45.0
                                    "SSE" -> arrowRotation = 67.5
                                    "S" -> arrowRotation = 90.0
                                    "SSW" -> arrowRotation = 112.5
                                    "SW" -> arrowRotation = 135.0
                                    "WSW" -> arrowRotation = 157.5
                                    "W" -> arrowRotation = 180.0
                                    "WNW" -> arrowRotation = 202.5
                                    "NW" -> arrowRotation = 225.0
                                    "NNW" -> arrowRotation = 247.5

                                }

                                Row(
                                    modifier = Modifier
                                        .width(90.dp)
                                        .background(
                                            Color(Constants.COL_PRIMARY_DARK),
                                            RoundedCornerShape(5.dp)
                                        )
                                ) {
                                    Image(
                                        painterResource(id = R.drawable.ic_current_wind_direction),
                                        contentDescription = "",
                                        modifier = Modifier
                                            .background(
                                                Color(Constants.COL_PRIMARY_DARK),
                                                RoundedCornerShape(5.dp)
                                            )
                                            .padding(start = 10.dp, end = 0.dp, top = 2.dp)
                                            .rotate(degrees = arrowRotation.toFloat())
                                    )
                                    Text(
                                        text = weather.current.wind_dir,
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
                            Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Wind speed",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.wind_kph.toString() + " km/h",
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
                                    text = "Wind gust",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.gust_kph.toString() + " km/h",
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

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Color(Constants.COL_PRIMARY_DARK),
                                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                                )
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "CURRENT INFORMATION",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )


                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Color(Constants.COL_THIRD),
                                    shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp)
                                )
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Feels like",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.feelslike_c.toString() + " °C",
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
                                    text = "Pressure",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.pressure_mb.toString() + " hPa",
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
                                    text = "Humidity",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.humidity.toString() + " %",
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
                                    text = "UV Index",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.uv.toString(),
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
                                    text = "Visibility",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.vis_km.toString() + " KM",
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
                                    text = "Precip",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.precip_mm.toString() + " mm",
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



                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Color(Constants.COL_PRIMARY_DARK),
                                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                                )
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "AIR QUALITY",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )


                        }
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Color(Constants.COL_THIRD),
                                    shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp)
                                )
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "[CO] Carbon monoxide ",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.air_quality.co.roundToInt()
                                        .toString() + "µg/m" + "\u00B3",
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
                                    text = "[NO₂] Nitrogen dioxide ",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.air_quality.no2.roundToInt()
                                        .toString() + " µg/m" + "\u00B3",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier
                                        .background(
                                            Color(Constants.COL_PRIMARY_DARK),
                                            RoundedCornerShape(5.dp)
                                        )
                                        .padding(5.dp),
                                    color = ColorHandler().getNO2Color(no2Value = weather.current.air_quality.no2)
                                )
                            }
                            Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))


                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "[O" + "\u2083" + "] Ozone ",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.air_quality.o3.roundToInt()
                                        .toString() + " µg/m" + "\u00B3",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier
                                        .background(
                                            Color(Constants.COL_PRIMARY_DARK),
                                            RoundedCornerShape(5.dp)
                                        )
                                        .padding(5.dp),
                                    color = ColorHandler().getO3Color(o3Value = weather.current.air_quality.o3)
                                )


                            }
                            Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))

                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "[SO₂] Sulfur dioxide ",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.air_quality.so2.roundToInt()
                                        .toString() + " µg/m" + "\u00B3",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier
                                        .background(
                                            Color(Constants.COL_PRIMARY_DARK),
                                            RoundedCornerShape(5.dp)
                                        )
                                        .padding(5.dp),
                                    color = ColorHandler().getSO2Color(so2Value = weather.current.air_quality.so2)
                                )


                            }
                            Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))

                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "[PM2.5] Particulate Matter ",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.air_quality.pm2_5.roundToInt()
                                        .toString() + " µg/m" + "\u00B3",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier
                                        .background(
                                            Color(Constants.COL_PRIMARY_DARK),
                                            RoundedCornerShape(5.dp)
                                        )
                                        .padding(5.dp),
                                    color = ColorHandler().getPM25Color(pm25Value = weather.current.air_quality.pm2_5)
                                )


                            }
                            Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))
                            
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "[PM10] Particulate Matter ",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )
                                Text(
                                    text = weather.current.air_quality.pm10.roundToInt()
                                        .toString() + " µg/m" + "\u00B3",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier
                                        .background(
                                            Color(Constants.COL_PRIMARY_DARK),
                                            RoundedCornerShape(5.dp)
                                        )
                                        .padding(5.dp),
                                    color = ColorHandler().getPM10Color(pm10Value = weather.current.air_quality.pm10.roundToInt())
                                )


                            }
                            Divider(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp))
     
                            Row(
                                modifier = Modifier.fillMaxSize(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "[AQI] Air Quality Index ",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )

                                Text(
                                    text = "\u00A0" + "\u00A0" + "\u00A0" + weather.current.air_quality.gbDefraIndex.toString() + "\u00A0" + "\u00A0" + "\u00A0",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    modifier = Modifier
                                        .background(
                                            ColorHandler().getDEFRAColor(defraValue = weather.current.air_quality.gbDefraIndex),
                                            RoundedCornerShape(5.dp)
                                        )
                                        .padding(5.dp)
                                )


                            }
                        }

                        Spacer(modifier = Modifier.height(50.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Color(Constants.COL_PRIMARY_DARK),
                                    shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                                )
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(
                                text = "WEATHER ALERTS",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center
                            )


                        }


                    }
                    var alertMsg: String

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Color(Constants.COL_THIRD),
                                shape = RoundedCornerShape(0.dp, 0.dp, 20.dp, 20.dp)
                            )
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center
                        ) {
                            if (weather.alerts.alert.isEmpty()) {
                                Text(
                                    text = "There are no current weather alerts at your location.",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Light,
                                    modifier = Modifier.padding(0.dp, 5.dp)
                                )

                            } else {

                                //for(key in weather.alerts.alert){
                                for (i in 0 until weather.alerts.alert.size){
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(
                                                Color(Constants.COL_PRIMARY_DARK),
                                                shape = RoundedCornerShape(20.dp, 20.dp, 0.dp, 0.dp)
                                            )
                                            .padding(10.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {

                                        Row() {
                                            Image(painterResource(id = R.drawable.ic_round_warning) , contentDescription = "Warning", modifier = Modifier.height(17.dp).padding(0.dp,2.dp,5.dp,0.dp))
                                            Text(
                                                text = weather.alerts.alert[i].category.uppercase() + " ALERT",
                                                fontSize = 15.sp,
                                                fontWeight = FontWeight.SemiBold,
                                                textAlign = TextAlign.Center,
                                                color = Color(Constants.WARNING_COLOR)
                                            )
                                            Image(painterResource(id = R.drawable.ic_round_warning) , contentDescription = "Warning", modifier = Modifier.height(17.dp).padding(5.dp,2.dp,0.dp,0.dp))

                                        }



                                    }
                                    Text(
                                        text = weather.alerts.alert[i].desc,

                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Light,
                                        modifier = Modifier.padding(5.dp, 5.dp)
                                    )
                                    Text(
                                        text = weather.alerts.alert[i].headline,

                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.ExtraLight,
                                        modifier = Modifier.padding(0.dp, 5.dp),
                                        textAlign = TextAlign.Center
                                    )
                                    Divider()
                                    Spacer(modifier = Modifier.height(15.dp))
                                }

                            }


                        }


                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    Spacer(modifier = Modifier.height(50.dp))
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {


                        val context = LocalContext.current
                        GetCurrentLocationUseCase().getFineLocation()

                        //Toast.makeText(context, "Test2: " + GetCurrentLocationUseCase().getFineLocation(), Toast.LENGTH_LONG).show()
                    }
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


