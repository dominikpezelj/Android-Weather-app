package com.weather.presentation.main_menu.main_bottom_navigation

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.weather.common.Constants
import com.weather.presentation.BottomNavItem

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.Forecast,
        BottomNavItem.Timezones,
        BottomNavItem.Compass,
        BottomNavItem.Settings,
    )
    androidx.compose.material.BottomNavigation(
        modifier = Modifier.graphicsLayer {
                                          shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            clip = true
        },
        backgroundColor = Color(Constants.COL_PRIMARY_DARK),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id=item.icon) , contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.LightGray,
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}