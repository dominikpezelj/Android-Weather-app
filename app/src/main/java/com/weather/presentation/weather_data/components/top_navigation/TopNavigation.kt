package com.weather.presentation.weather_data.components.top_navigation

import androidx.compose.animation.Animatable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.weather.common.Constants
import com.weather.presentation.weather_data.WeatherDetailState
import com.weather.presentation.weather_data.components.top_navigation.handler.TopNavigationHandler
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TopNavigation(state: WeatherDetailState, pagerState: PagerState) {
    Column(modifier = Modifier.background(color = Color.Transparent)) {
        val list = listOf("Current", "Forecast", "Astronomy")
        val scope = rememberCoroutineScope()
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = Color(Constants.COL_THIRD),
            contentColor = Color(Constants.COL_THIRD),
            /*divider = {
                TabRowDefaults.Divider(
                    thickness = 1.dp,
                    color = Color(Constants.COL_THIRD)
                )
            },*/
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier
                        .pagerTabIndicatorOffset(pagerState, tabPositions)
                        .height(0.dp)
                        .width(0.dp)
                )
            },
            modifier = Modifier
                .background(Color(Constants.COL_SECONDARY_DARK))
                .padding(10.dp)

                .clip(
                    RoundedCornerShape(20.dp)
                )

        ) {

            list.forEachIndexed { index, _ ->
                val color = remember {
                    Animatable(Color(Constants.COL_THIRD))
                }
                LaunchedEffect(pagerState.currentPage == index ){
                    color.animateTo(if(pagerState.currentPage ==  index) Color(Constants.COL_PRIMARY_DARK) else Color(Constants.COL_THIRD))
                }
                Tab(
                    selected = pagerState.currentPage == index,
                    text = {

                        Text(text = list[index],
                            style =
                                if (pagerState.currentPage == index)
                                    TextStyle(
                                        color = Color.White,
                                        fontSize = 13.sp
                                    )
                                else TextStyle(
                                    color = Color.White, fontSize = 11.sp
                                )

                            )
                    },

                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    modifier = Modifier
                        .background(color = color.value, shape = RoundedCornerShape(30.dp))
                        .height(30.dp)


                )
            }


        }




        TopNavigationHandler(state = state, pagerState = pagerState)


    }

}