package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
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
import android.graphics.Color as AndroidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReasonReportScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        ReasonReportForm(
            padding = padding,
            contex = contex
        )
    }

}

@Composable
fun ReasonReportForm(
    padding: PaddingValues,
    contex: Context
) {

    var motivo by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Text(
            text = "REPORTE RECHAZADO",
            fontSize = 25.sp,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .height(50.dp)
        )

        Icon(imageVector = Icons.Rounded.Email,
            contentDescription = "Logo de la app",
            modifier = Modifier
                .padding(25.dp)
                .size(50.dp))

        Text(text = "Motivo del rechazo del reporte: ",
            fontSize = 17.sp,
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp))

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Box(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            TextField(
                value = motivo,
                onValueChange = { motivo = it },
                label = { Text("Motivo") },
                modifier = Modifier
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier
            .height(50.dp))

        Button(
            colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
            onClick = {}
        ) {
            Text(text = "Enviar motivo",
                fontSize = 18.sp)
        }
    }
}