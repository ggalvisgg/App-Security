package com.appsecurity.ui.user.tabs

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import android.graphics.Color as AndroidColor
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsecurity.R
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
fun GenerarReporteUserTab(
    navigateToHome: () -> Unit,
    navigateToUserReport : () -> Unit
){

    Column(
        modifier = Modifier
            .padding(10.dp, top = 50.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val context = LocalContext.current
        var nuevoReporte by rememberSaveable { mutableStateOf("") }

        Text(text = stringResource(id = R.string.titleCrearReporte),
            fontSize = 30.sp,
            //modifier = Modifier.padding(top =12 .dp)
        )

        Spacer(modifier = Modifier
            .height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.titleCrearReporte))

            Icon(imageVector = Icons.Rounded.Phone,
                contentDescription = "Icono de subir foto del reporte creado",
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Top))
        }

        Spacer(modifier = Modifier
            .height(20.dp))

        Text(text = stringResource(id = R.string.subtitleCategoria),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp),
            fontSize = 20.sp)

        Spacer(modifier = Modifier
            .height(10.dp))

        TextField(
            value = nuevoReporte,
            onValueChange = { nuevoReporte = it },
            label = { Text("Categoria") }
        )

        Spacer(modifier = Modifier
            .height(20.dp))

        Text(text = stringResource(id = R.string.subtitleDescripcionReporte),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp),
            fontSize = 20.sp)

        Spacer(modifier = Modifier
            .height(10.dp))

        TextField(
            value = nuevoReporte,
            onValueChange = { nuevoReporte = it },
            label = { Text("Descripcion del reporte") }
        )

        Spacer(modifier = Modifier
            .height(20.dp))

        Text(text = stringResource(id = R.string.subtitleElegirUbicacion),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp),
            fontSize = 20.sp)

        Spacer(modifier = Modifier
            .height(10.dp))

        var pointClicked by remember { mutableStateOf<Point?>(null) }
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
            modifier = Modifier
                .height(200.dp)
                .width(400.dp)
                .padding(start = 10.dp, end = 10.dp),
            mapViewportState = mapViewportState,
            onMapClickListener = { point ->
                pointClicked = point
//                Toast.makeText(context, "Click en el mapa ${point.latitude()} ${point.longitude()}",
//                    Toast.LENGTH_LONG).show()
                true
            }
        ){
            UbicationGPS(mapViewportState)

            pointClicked?.let {
                PointAnnotation(
                    point = pointClicked!!
                ) {
                    iconImage = marker
                }
            }
        }

        Spacer(modifier = Modifier
            .height(5.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
        ){

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {
                    navigateToUserReport()
                }
            ) {
                Text(text = stringResource(id = R.string.buttonCrearReporte),
                    fontSize = 18.sp)
            }

            Spacer(modifier = Modifier
                .width(10.dp))

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#9177C7"))),
                onClick = {
                    navigateToHome()
                }
            ) {
                Text(text = stringResource(R.string.buttonCancelar),
                    fontSize = 18.sp)
            }
        }

    }

}