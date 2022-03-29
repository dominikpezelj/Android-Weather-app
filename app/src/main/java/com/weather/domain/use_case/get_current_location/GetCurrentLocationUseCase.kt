package com.weather.domain.use_case.get_current_location

import android.location.Location
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.android.gms.location.LocationServices

class GetCurrentLocationUseCase {
    @OptIn(ExperimentalPermissionsApi::class)
    @Composable
    fun getFineLocation() {
        val context = LocalContext.current
        LocationPermission().initLocationPermissions()

        if (LocationPermission().isLocationEnabled(context)) {

            //com.weather.common.Toast().showToast(context = context, content = "Location enabled")
            LocationPermission().checkSelfPermission(context)
            LocationServices.getFusedLocationProviderClient(context).lastLocation.addOnCompleteListener { task ->
                val location: Location? = task.result
                //GetLocationGeoCoder().geoCoder(context = context, location = location)

                //com.weather.common.Toast().showToast(context = context, content = "Test3: "+GetLocationGeoCoder().locationToString(context = context, location = location))
                //SharedLocation(GetLocationGeoCoder().locationToString(context = context, location = location))
                //SharedLocation(sharedLocation = GetLocationGeoCoder().locationToString(context = context, location = location))
                GetLocationGeoCoder().locationToString(context = context, location = location)

            }
        }else {
            com.weather.common.Toast().showToast(context = context, content = "Please enable location!")

        }

    }

}


