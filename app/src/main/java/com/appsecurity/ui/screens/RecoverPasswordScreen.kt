package com.appsecurity.ui.screens

import android.content.Context
import android.graphics.Color as AndroidColor
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecoverPasswordScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        RecoverPassForm(
            padding = padding,
            contex = contex
        )
    }

}

@Composable
fun RecoverPassForm(
    padding: PaddingValues,
    contex : Context
){

    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
        .padding()
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {

        Text(text = "RECUPERACION DE TU \nDE TU CONTRASEÑA",
            fontSize = 25.sp,
            textAlign = TextAlign.Center)

        Spacer(modifier = Modifier
            .height(50.dp))

        Text(text= "CREAR NUEVA CONTRASEÑA",
            fontSize = 18.sp)

        Spacer(modifier = Modifier
            .height(50.dp))

        //Hace falta los checkboxs para ver la contraseña y ocultar
        Text(text = "Nueva contraseña",
            fontSize = 18.sp,
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("***********") }
        )

        Spacer(modifier = Modifier
            .height(20.dp))

        Text(text = "Confirma la contraseña",
            fontSize = 18.sp,
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("**************") }
        )

        Spacer(modifier = Modifier
            .height(50.dp))

        Button(
            colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
            onClick = {}
        ) {
            Text(text = "Aceptar",
                fontSize = 18.sp)
        }

        //este texto debe aparecer cuando la contraseña este configurada
        Spacer(modifier = Modifier
            .height(20.dp))
        Text(text = "La contraseña fue cambaida con exito!",
            fontSize = 15.sp)
    }

}