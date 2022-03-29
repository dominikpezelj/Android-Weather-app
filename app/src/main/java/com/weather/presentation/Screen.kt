package com.weather.presentation

import com.weather.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object Forecast : BottomNavItem("Forecast", R.drawable.ic_menu_location, "forecast_detail_screen")
    object Timezones : BottomNavItem(
        "Timezones",
        R.drawable.ic_menu_timezones, "timezone_detail_screen"
    )

    object Compass : BottomNavItem("Compass", R.drawable.ic_menu_compass, "compass_detail_screen")
    object Settings : BottomNavItem(
        "Settings",
        R.drawable.ic_menu_settings, "settings_detail_screen"
    )


}