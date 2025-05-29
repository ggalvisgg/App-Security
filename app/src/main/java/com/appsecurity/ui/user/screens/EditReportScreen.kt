package com.appsecurity.ui.user.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appsecurity.R
import com.appsecurity.model.Reporte
import com.appsecurity.viewmodel.ReporteViewModel
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.generated.PointAnnotation
import com.mapbox.maps.extension.compose.annotation.rememberIconImage
import android.graphics.Color as AndroidColor
import com.mapbox.geojson.Point

@Composable
fun EditReportScreen(
    navigateToReportResuelto: () -> Unit,
    navigateToReportNoResuelto: () -> Unit,
    navigateToMyReports: () -> Unit
){

    var contex = LocalContext.current

    Scaffold { padding ->
        EditReportForm(
            padding = padding,
            contex = contex,
            navigateToReportResuelto = {
                navigateToReportResuelto()
            },
            navigateToReportNoResuelto = {
                navigateToReportNoResuelto()
            },
            navigateToMyReports = {
                navigateToMyReports()
            },
            reporte = Reporte()
        )
    }
}

@Composable
fun EditReportForm(
    padding: PaddingValues,
    contex : Context,
    reporte: Reporte,
    navigateToReportResuelto: () -> Unit,
    navigateToReportNoResuelto: () -> Unit,
    navigateToMyReports: () -> Unit
){
    Column(
        modifier = Modifier
            .padding(10.dp, top=50.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val viewModel: ReporteViewModel = viewModel()

        var categoria by rememberSaveable { mutableStateOf(reporte.categoria) }
        var descripcion by rememberSaveable { mutableStateOf(reporte.descripcion) }

        Text(text = stringResource(id = R.string.titleEditarReporte),
            fontSize = 30.sp,
            //modifier = Modifier.padding(top =12 .dp)
        )

        Spacer(modifier = Modifier
            .height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.textCargarFoto))

            Icon(imageVector = Icons.Rounded.Phone,
                contentDescription = stringResource(id = R.string.textIconFotoReporte),
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Top))
        }

        Spacer(modifier = Modifier
            .height(20.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
        ){

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {
                    navigateToReportResuelto()
                }
            ) {
                Text(text = stringResource(id = R.string.buttonResuelto),
                    fontSize = 18.sp)
            }

            Spacer(modifier = Modifier
                .width(10.dp))

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#9177C7"))),
                onClick = {
                    navigateToReportNoResuelto()
                }
            ) {
                Text(text = stringResource(id = R.string.buttonNoResuelto),
                    fontSize = 18.sp)
            }
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
            value = categoria,
            onValueChange = { categoria = it }
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
            value = descripcion,
            onValueChange = { descripcion = it }
        )

        Spacer(modifier = Modifier
            .height(20.dp))

        Text(text = stringResource(id = R.string.subtitleElegirUbicacion),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp),
            fontSize = 20.sp)

        Spacer(modifier = Modifier
            .height(5.dp))

        Spacer(modifier = Modifier.height(20.dp))

        var pointClicked by remember {
            mutableStateOf(Point.fromLngLat(reporte.longitud, reporte.latitud))
        }

        val mapViewportState = rememberMapViewportState {
            setCameraOptions {
                zoom(14.0)
                center(pointClicked)
            }
        }

        val marker = rememberIconImage(
            key = R.drawable.gps,
            painter = painterResource(R.drawable.gps)
        )

        MapboxMap(
            modifier = Modifier
                .height(200.dp)
                .width(350.dp)
                .padding(10.dp),
            mapViewportState = mapViewportState,
            onMapClickListener = { newPoint ->
                pointClicked = newPoint
                true
            }
        ) {
            PointAnnotation(point = pointClicked) {
                iconImage = marker
            }
        }

        Spacer(modifier = Modifier
            .height(5.dp))

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {
                    val reporteEditado = reporte.copy(
                        categoria = categoria,
                        descripcion = descripcion,
                        latitud = pointClicked.latitude(),
                        longitud = pointClicked.longitude()
                    )

                    viewModel.actualizarReporte(reporteEditado,
                        onSuccess = {
                            Toast.makeText(contex, "Reporte actualizado", Toast.LENGTH_SHORT).show()
                            navigateToMyReports()
                        },
                        onError = {
                            Toast.makeText(contex, it, Toast.LENGTH_LONG).show()
                        }
                    )
                }
            ) {
                Text(text = stringResource(id = R.string.buttonEditarReporte),
                    fontSize = 18.sp)
            }
    }
}