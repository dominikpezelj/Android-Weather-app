package com.weather.presentation.main_menu.main_navigation_bar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.weather.common.Constants

@Composable
fun TopBar() {

    TopAppBar(
        title = {
            Text(
                text = "Weather",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),

            )
        },
        backgroundColor = Color(Constants.COL_PRIMARY_DARK)



        )
}