package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.graphics.Color as AndroidColor

@Composable
fun WatchNotificationScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        WatchNotiForm(
            padding = padding,
            contex = contex
        )
    }

}

@Composable
fun WatchNotiForm(
    padding: PaddingValues,
    contex: Context
){

    Column (
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(text= "NOTIFICACIONES",
            fontSize = 30.sp,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier
            .height(40.dp))

        Box(
            modifier = Modifier
                .padding(20.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.Info,
                    contentDescription = "Logo de la notificación",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(30.dp),
                tint = Color(0xFF63578A)
                )

                Column {
                    Text(text = "Maria Garces")
                    Text(text = "Ha comentado en tu reporte de mascotas, revísalo")
                }
            }
        }

    }
}