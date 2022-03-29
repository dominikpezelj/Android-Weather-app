package com.weather.domain.use_case.get_current_location

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.location.Location
import com.weather.data.remote.dto.FineLocation
import java.util.*

class GetLocationGeoCoder {
    fun geoCoder(context:Context, location: Location?) {

            if (location == null) {
                //getLastLocation()
                    com.weather.common.Toast().showToast(context = context, content = "Unknown location")
                //Loading screen?

            } else {
                locationToString(context = context, location = location)

                }

            }





 fun locationToString(context: Context, location: Location?):String {
    val geoCoder = Geocoder(context, Locale.getDefault())
     if (location != null) {
         /*com.weather.common.Toast().showToast(
             context = context,
             content = "Lat: ${location.latitude} \n Long: ${location.longitude}"
         )*/
     }

    var address: MutableList<Address>? =
        location?.let { geoCoder.getFromLocation(it.latitude, location.longitude, 1) }
    if (address != null) {
       // FineLocation(location = address!![0].locality.toString())
        FineLocation.phoneLocation = address!![0].locality.toString()
        //FineLocation.phoneLocation = address[0].locality.toString()
        // cityName.text = Address.get(0).locality
        //findViewById<TextView>(R.id.cityName).text = address[0].locality

        /*com.weather.common.Toast().showToast(
            context = context,
            content = "Test1: " + address!![0].locality.toString()
        )*/
        //return address!![0].locality.toString()
    }else {
        com.weather.common.Toast().showToast(context = context, content = "Cant find City.")
    }
    return address!![0].locality.toString()
}
}

