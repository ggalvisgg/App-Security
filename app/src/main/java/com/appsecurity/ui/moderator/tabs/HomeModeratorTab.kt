package com.appsecurity.ui.moderator.tabs

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.appsecurity.R
import com.appsecurity.ui.component.ActivationGps
import com.appsecurity.ui.component.UbicationGPS
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.generated.PointAnnotation
import com.mapbox.maps.extension.compose.annotation.rememberIconImage

@Composable
fun HomeModeratorTab(){

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
                //navigateToInformationAllReport()
                true
            }
        }
    }

}