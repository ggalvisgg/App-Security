package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsecurity.R
import android.graphics.Color as AndroidColor

@Composable
fun WatchAllComentsScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        WatchAllComentsForm(
            padding = padding,
            contex = contex
        )
    }

}

@Composable
fun WatchAllComentsForm(
    padding: PaddingValues,
    contex: Context
){

    var comentario by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ){

        Text(text = stringResource(id = R.string.titleComentarios),
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 40.dp))

        Spacer(modifier = Modifier
            .height(30.dp))

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