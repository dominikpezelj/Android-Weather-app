package com.weather.presentation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.weather.presentation.main_menu.main_bottom_navigation.NavigationGraph
import com.weather.presentation.theme.WeatherTheme
import com.weather.presentation.main_menu.main_navigation_bar.TopBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalPagerApi

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState: ScaffoldState = rememberScaffoldState()
            val navController = rememberNavController()

            WeatherTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    ) {

                    Scaffold(
                        scaffoldState = scaffoldState,
                        modifier = Modifier.wrapContentSize(Alignment.Center),
                        topBar = { TopBar() },
                        bottomBar = { com.weather.presentation.main_menu.main_bottom_navigation.BottomNavigation(
                            navController = navController
                        ) }

                    ) {

                        NavigationGraph(navController = navController)

                    }
                }


            }

        }
    }
}






















