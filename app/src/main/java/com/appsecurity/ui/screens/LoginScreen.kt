package com.appsecurity.ui.screens

import androidx.compose.runtime.Composable
import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsecurity.ui.component.TextFieldForm
import android.graphics.Color as AndroidColor

@Composable
fun LoginScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        LoginForm(
            padding = padding,
            contex = contex
        )
    }
}

@Composable
fun LoginForm(
    padding: PaddingValues,
    contex: Context
){

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "INICIAR SESION",
            fontSize = 25.sp)

        Icon(imageVector = Icons.Rounded.AccountCircle,
            contentDescription = "Logo de la app",
            modifier = Modifier
                .padding(50.dp))

        Text(text = "Correo electronico",
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 70.dp)
        )

        TextFieldForm(
            value = email,
            onValueChange = {
                email = it
            },
            label = "",
            supportingText = "El correo no es valido",
            placeholder = "email@gmail.com",

            //Toda la logica de validacion va aqui
            onValidate = {
                !Patterns.EMAIL_ADDRESS.matcher(it).matches()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Contraseña",
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 70.dp)
        )

        TextFieldForm(
            value = password,
            onValueChange = {
                password = it
            },
            supportingText = "La contraseña debe tener minimo 8 caracteres",
            placeholder = "**********",
            label = "",
            onValidate = {
                it.length < 8
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            isPassword = true
        )

        Text(
            buildAnnotatedString {
                val link =
                    LinkAnnotation.Url(
                        "https://developer.android.com/jetpack/compose",
                        TextLinkStyles(SpanStyle(Color(AndroidColor.parseColor("#7251B5"))))
                    ) {
                        val url = (it as LinkAnnotation.Url).url
                        uriHandler.openUri(url)
                    }
                withLink(link) { append("¿Olvidaste tu contraseña?") }
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 70.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button (
                enabled = email.isNotEmpty() && password.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {
                    if(email =="gabriela" && password=="12345678"){
                        Toast.makeText(contex, "Bienvenido", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(contex, "Correo o contraseña incorrecta", Toast.LENGTH_SHORT).show()
                    }
                }){

                Icon(
                    imageVector = Icons.Rounded.Done,
                    contentDescription = "Icono de inicio",
                    modifier = Modifier
                        .padding(3.dp)
                )
                Text(text = "Iniciar sesion")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            buildAnnotatedString {
                append("No tienes cuenta?")
                val link =
                    LinkAnnotation.Url(
                        "https://developer.android.com/jetpack/compose",
                        TextLinkStyles(SpanStyle(Color(AndroidColor.parseColor("#7251B5"))))
                    ) {
                        val url = (it as LinkAnnotation.Url).url
                        uriHandler.openUri(url)
                    }
                withLink(link) { append(" Registrate aqui") }
            }
        )
    }
}