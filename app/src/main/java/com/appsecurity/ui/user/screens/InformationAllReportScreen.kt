package com.appsecurity.ui.user.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import android.graphics.Color as AndroidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.appsecurity.R
import com.appsecurity.model.Reporte

@Composable
fun InformationAllReportScreen(
    navigationToComents: () -> Unit
){

    val contex = LocalContext.current

    Scaffold { padding ->
        InformationReportForm(
            padding = padding,
            contex = contex,
            navigationToComents = {
                navigationToComents()
            },
            reporte = Reporte()
        )
    }
}

@Composable
fun InformationReportForm(
    padding: PaddingValues,
    contex: Context,
    reporte: Reporte,
    navigationToComents: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = stringResource(id = R.string.titleReporte), fontSize = 30.sp)

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Categoría: ${reporte.categoria}",
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 50.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Imagen del reporte
        AsyncImage(
            model = reporte.urlImagen,
            contentDescription = "Imagen del reporte",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row {
            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = { /* Información del reporte actual */ }
            ) {
                Text(text = stringResource(id = R.string.buttonInformacion), fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                colors = ButtonDefaults.buttonColors(Color.White),
                onClick = {
                    navigationToComents()
                }
            ) {
                Text(text = stringResource(id = R.string.buttonComentarios), fontSize = 18.sp, color = Color.Black)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.Person,
                        contentDescription = "Usuario",
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Usuario ID: ${reporte.uidUsuario}", fontSize = 20.sp)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.MailOutline,
                        contentDescription = "Detalle",
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = reporte.descripcion, fontSize = 20.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Ubicación del reporte")

        Spacer(modifier = Modifier.height(10.dp))

//        MapboxMap(
//            modifier = Modifier
//                .height(200.dp)
//                .width(350.dp)
//                .padding(10.dp),
//            mapViewportState = rememberMapViewportState {
//                setCameraOptions {
//                    zoom(14.0)
//                    center(Point.fromLngLat(reporte.longitud, reporte.latitud))
//                }
//            }
//        ) {
//            PointAnnotation(point = Point.fromLngLat(reporte.longitud, reporte.latitud)) {
//                iconImage = rememberIconImage(
//                    key = R.drawable.gps,
//                    painter = painterResource(R.drawable.gps)
//                )
//            }
//        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "10 personas", fontSize = 20.sp)

            Spacer(modifier = Modifier.width(5.dp))

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {
                    // Lo dejaremos para el final (marcar como relevante)
                }
            ) {
                Text(text = stringResource(id = R.string.buttonRelevante), fontSize = 18.sp)
            }
        }
    }
}

