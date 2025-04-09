package com.appsecurity.ui.screens

import android.content.Context
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.graphics.Color as AndroidColor
import androidx.compose.ui.res.stringResource
import com.appsecurity.R

@Composable
fun UserCreateReportScreen(
    navigateToHome: () -> Unit,
    navigateToUserReport: () -> Unit
){
    var contex = LocalContext.current

    Scaffold { padding ->
        CreateReportForm(
            padding = padding,
            contex = contex,
            navigateToHome = {
                navigateToHome()
            },
            navigateToUserReport = {
                navigateToUserReport()
            }
        )
    }
}

@Composable
fun CreateReportForm(
    padding: PaddingValues,
    contex : Context,
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
            .height(20.dp))

        TextField(
            value = nuevoReporte,
            onValueChange = { nuevoReporte = it },
            label = { Text("MAPA") }
        )

        Spacer(modifier = Modifier
            .height(30.dp))

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