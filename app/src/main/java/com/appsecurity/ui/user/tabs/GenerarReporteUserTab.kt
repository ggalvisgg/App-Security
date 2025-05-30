package com.appsecurity.ui.user.tabs

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import android.graphics.Color as AndroidColor
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appsecurity.R
import com.appsecurity.model.CategoriaReporte
import com.appsecurity.model.Reporte
import com.appsecurity.ui.component.CategoriaDropdown
import com.appsecurity.ui.component.UbicationGPS
import com.appsecurity.viewmodel.ReporteViewModel
import com.google.firebase.auth.FirebaseAuth
import com.mapbox.geojson.Point
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.generated.PointAnnotation
import com.mapbox.maps.extension.compose.annotation.rememberIconImage


@Composable
fun GenerarReporteUserTab(
    navigateToHome: () -> Unit,
    navigateToUserReport: () -> Unit
) {
    val context = LocalContext.current
    val viewModel: ReporteViewModel = viewModel()

    var categoriaSeleccionada by rememberSaveable { mutableStateOf(CategoriaReporte.SEGURIDAD) }
    var descripcion by rememberSaveable { mutableStateOf("") }
    var imagenUri by rememberSaveable { mutableStateOf<Uri?>(null) }
    var pointClicked by remember { mutableStateOf<Point?>(null) }

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        imagenUri = uri
    }

    val uid = FirebaseAuth.getInstance().currentUser?.uid ?: ""


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

    Column(
        modifier = Modifier
            .padding(10.dp, top = 50.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(text = "Crear Reporte", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { launcher.launch("image/*") }) {
            Text("Seleccionar Imagen")
        }

        imagenUri?.let {
            Spacer(modifier = Modifier.height(10.dp))
            Text("Imagen seleccionada: ${it.lastPathSegment}")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text("Categoría", fontSize = 20.sp, modifier = Modifier.align(Alignment.Start).padding(start = 60.dp))

        CategoriaDropdown(
            categoriaSeleccionada = categoriaSeleccionada,
            onCategoriaSeleccionada = { categoriaSeleccionada = it }
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text("Descripción", fontSize = 20.sp, modifier = Modifier.align(Alignment.Start).padding(start = 60.dp))
        TextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Describe el incidente...") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Ubicación", fontSize = 20.sp, modifier = Modifier.align(Alignment.Start).padding(start = 60.dp))

        MapboxMap(
            modifier = Modifier
                .height(200.dp)
                .width(400.dp)
                .padding(10.dp),
            mapViewportState = mapViewportState,
            onMapClickListener = { point ->
                pointClicked = point
                true
            }
        ) {
            UbicationGPS(mapViewportState)

            pointClicked?.let {
                PointAnnotation(point = it) {
                    iconImage = marker
                }
            }
        }


        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {
                    viewModel.crearReporte(
                        titulo = "Reporte desde app",
                        descripcion = descripcion,
                        categoria = categoriaSeleccionada,
                        point = pointClicked,
                        imagenUri = imagenUri,
                        context = context
                    )
                }
            ) {
                Text("Crear Reporte", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#9177C7"))),
                onClick = {
                    navigateToHome()
                }
            ) {
                Text("Cancelar", fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Estado del ViewModel
        if (viewModel.reporteCreado) {
            Toast.makeText(context, "Reporte creado exitosamente", Toast.LENGTH_SHORT).show()
            viewModel.limpiarEstado()
            navigateToUserReport()
        }

        viewModel.mensajeError?.let {
            Text(text = it, color = Color.Red, modifier = Modifier.padding(8.dp))
        }
    }
}
