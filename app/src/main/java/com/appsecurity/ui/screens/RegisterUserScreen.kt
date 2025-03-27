package com.appsecurity.ui.screens

import android.content.Context
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.sp
import android.graphics.Color as AndroidColor

@Composable
fun RegisterUserScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        RegisterForm(
            padding = padding,
            contex = contex
        )
    }

}

@Composable
fun RegisterForm(
    padding: PaddingValues,
    contex: Context
) {

    var email by rememberSaveable { mutableStateOf("") }
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .padding(10.dp, top = 50.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Top,
        //verticalArrangement = Arrangement.Center
        //horizontalAlignment = Alignment.Start
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "REGISTRO",
            fontSize = 25.sp,
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Text(
            text = "Informacion personal",
            fontSize = 20.sp,
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = "Nombre completo",
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Andrea Martina Giraldo") }
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = "Ciudad de residencia",
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Quimbaya") }
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = "Dirección",
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("MZ 4 CRA 3") }
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = "Datos de acceso",
            fontSize = 20.sp,
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = "Correo electronico",
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("correo@gmail.com") }
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = "Contraseña",
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("*********") }
        )

        Spacer(
            modifier = Modifier
                .height(15.dp)
        )

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {}
            ) {
                Text(
                    text = "Registrarse",
                    fontSize = 18.sp
                )
            }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            buildAnnotatedString {
                append("Ya tienes cuenta?")
                val link =
                    LinkAnnotation.Url(
                        "https://developer.android.com/jetpack/compose",
                        TextLinkStyles(SpanStyle(Color(AndroidColor.parseColor("#7251B5"))))
                    ) {
                        val url = (it as LinkAnnotation.Url).url
                        uriHandler.openUri(url)
                    }
                withLink(link) { append(" Ingresa aquí") }
            },
            fontSize = 18.sp
        )



    }
}