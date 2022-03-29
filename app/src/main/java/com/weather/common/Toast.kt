package com.weather.common

import android.content.Context
import android.widget.Toast

class Toast {
    fun showToast(context:Context, content:String) {
        Toast.makeText(context, content, Toast.LENGTH_SHORT).show()
    }
}