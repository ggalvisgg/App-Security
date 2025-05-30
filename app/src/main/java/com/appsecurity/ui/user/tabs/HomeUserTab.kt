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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appsecurity.R
import com.appsecurity.ui.component.ActivationGps
import com.appsecurity.ui.component.UbicationGPS
import com.appsecurity.viewmodel.ReporteViewModel
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
    navigateToInformationAllReport: () -> Unit,
    viewModel: ReporteViewModel = viewModel()
) {

    ActivationGps()

    val reportes = viewModel.listaTodosReportes

    // Obtener todos los reportes al entrar
    LaunchedEffect(Unit) {
        viewModel.obtenerTodosLosReportes()
    }

    val mapViewportState = rememberMapViewportState {
        setCameraOptions {
            zoom(10.0)
            center(Point.fromLngLat(-75.7358251, 4.4721139))
        }
    }

    val marker = rememberIconImage(
        key = R.drawable.gps,
        painter = painterResource(R.drawable.gps)
    )

    MapboxMap(
        modifier = Modifier.fillMaxSize(),
        mapViewportState = mapViewportState
    ) {
        UbicationGPS(mapViewportState)

        // Mostrar marcador por cada reporte
        reportes.forEach { reporte ->
            val point = Point.fromLngLat(reporte.longitud, reporte.latitud)

            PointAnnotation(point = point) {
                iconImage = marker

                // Al hacer clic en el marcador
                interactionsState.onClicked {
                    // Aquí puedes pasar el ID del reporte si luego quieres navegar a su detalle
                    navigateToInformationAllReport()
                    true
                }
            }
        }
    }
}
