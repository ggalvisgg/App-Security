package com.appsecurity.ui.user.tabs

import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.content.ContextCompat
import com.appsecurity.R
import com.appsecurity.ui.component.ActivationGps
import com.appsecurity.ui.component.UbicationGPS
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapEffect
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.generated.PointAnnotation
import com.mapbox.maps.extension.compose.annotation.rememberIconImage
import com.mapbox.maps.plugin.PuckBearing
import com.mapbox.maps.plugin.locationcomponent.createDefault2DPuck
import com.mapbox.maps.plugin.locationcomponent.location

@Composable
fun HomeUserTab(
    navigateToInformationAllReport : () -> Unit
){
    ActivationGps()

    var mapViewportState = rememberMapViewportState {

        setCameraOptions {
           zoom(10.0)
            center(Point.fromLngLat(-75.7358251, 4.4721139))
        }
    }

    var markerResourceId by remember {
        mutableStateOf(R.drawable.gps)
    }

    var marker = rememberIconImage(key = markerResourceId, painter = painterResource(markerResourceId))

    MapboxMap(
        modifier = Modifier.fillMaxSize(),
        mapViewportState = mapViewportState
    ){

        UbicationGPS(mapViewportState)

        PointAnnotation(
            point = Point.fromLngLat(-75.7358251, 4.4721139),
        ) {
            iconImage = marker
            interactionsState.onClicked {
                navigateToInformationAllReport()
                true
            }
        }
    }

}