package com.appsecurity.ui.screens

import android.content.Context
import android.text.Layout
import androidx.compose.foundation.background
import android.graphics.Color as AndroidColor
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Star
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsecurity.R

@Composable
fun WatchComentsScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        WatchComentsForm(
            padding = padding,
            contex = contex
        )
    }
}

@Composable
fun WatchComentsForm(
    padding: PaddingValues,
    contex: Context
){

    var comentario by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(text = stringResource(id = R.string.titleReporte),
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top=50.dp))

        Spacer(modifier = Modifier
            .height(20.dp))

        Text(text = "estrellas",
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 50.dp))

        Spacer(modifier = Modifier
            .height(5.dp))

        Text(text = "Categoria: Mascotas",
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 50.dp))

        Spacer(modifier = Modifier
            .height(5.dp))

        Row {
            Icon(imageVector = Icons.Rounded.AccountBox,
                contentDescription = stringResource(id = R.string.textIconImagenSuceso),
                modifier = Modifier
                    .size(80.dp))

            Icon(imageVector = Icons.Rounded.AccountBox,
                contentDescription = stringResource(id = R.string.textIconImagenSuceso))
        }

        Spacer(modifier = Modifier
            .height(15.dp))

        Row {
            Button(
                colors = ButtonDefaults.buttonColors(Color.White),
                onClick = {}
            ) {
                Text(text = stringResource(id = R.string.buttonInformacion),
                    fontSize = 18.sp,
                    color = Color.Black)
            }

            Spacer(modifier = Modifier
                .width(10.dp))

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {}
            ) {
                Text(text = stringResource(id = R.string.buttonComentarios),
                    fontSize = 18.sp)
            }
        }

        Spacer(modifier = Modifier
            .height(20.dp))

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
                Column(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                ) {
                    Row (verticalAlignment = Alignment.CenterVertically){

                        Text(text = "Maria Garces",
                            fontSize = 18.sp)

                        Spacer(modifier = Modifier
                            .width(10.dp))

                        Icon(
                            imageVector = Icons.Rounded.Star,
                            contentDescription = stringResource(id = R.string.textIconCalificacion),
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .size(30.dp),
                            tint = Color(0xFF63578A),
                        )
                    }

                    Spacer(modifier = Modifier
                        .height(5.dp))
                    Text(text = "Yo vi un perro igual al que ponen en la imagen",
                        fontSize = 18.sp)
                }
            }
        }

        Button(
            colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
            onClick = {},
            modifier = Modifier
                .align(Alignment.End)
                .padding(end=20.dp)
        ) {
            Text(text = stringResource(id = R.string.buttonVerTodos),
                fontSize = 15.sp)
        }

        Spacer(modifier = Modifier
            .height(40.dp))

        Text(text = stringResource(id = R.string.subtitleDejarComentario),
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 30.dp))

        TextField(
            value = comentario,
            onValueChange = { comentario = it },
            label = { Text("Escribe tu comentario...") },
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        Spacer(modifier = Modifier
            .height(8.dp))

        Button(
            colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
            onClick = {},
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 30.dp)
        ) {
            Text(text = stringResource(id = R.string.buttonComentar),
                fontSize = 18.sp)
        }

    }

}