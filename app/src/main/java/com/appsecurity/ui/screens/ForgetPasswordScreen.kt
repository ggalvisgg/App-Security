package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.graphics.Color as AndroidColor

@Composable
fun ForgetPasswordScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        ForgetPassForm(
            padding = padding,
            contex = contex
        )
    }
}

@Composable
fun ForgetPassForm(
    padding : PaddingValues,
    contex : Context
){

    var nuevaContraseña by rememberSaveable { mutableStateOf("") }

    Column (
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(text = "OLVIDASTE TU \nCONTRASEÑA",
                fontSize = 20.sp)

        Spacer(modifier = Modifier
            .height(50.dp))

        Text(text = "RECUPERACION DE CONTRASEÑA",
            fontSize = 15.sp)

        Spacer(modifier = Modifier
            .height(15.dp))

        Text(text = "Ingrese el correo electronico",
            fontSize = 13.sp)

        Spacer(modifier = Modifier
            .height(10.dp))

        TextField(
            value = nuevaContraseña,
            onValueChange = { nuevaContraseña = it },
            label = { Text("Nueva contraseña") }
        )

        Spacer(modifier = Modifier
            .height(30.dp))

        Button(
            colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
            onClick = {}
        ) {
            Text(text = "Enviar correo",
                fontSize = 18.sp)
        }
    }

}