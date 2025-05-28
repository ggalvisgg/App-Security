package com.appsecurity.ui.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import android.graphics.Color as AndroidColor
import com.appsecurity.R
import com.appsecurity.model.TipoUsuario
import com.appsecurity.model.Usuario
import com.appsecurity.viewmodel.AuthViewModel

@Composable
fun RegisterUserScreen(
    navigateToLogin: () -> Unit
){

    val contex = LocalContext.current

    Scaffold { padding ->
        RegisterForm(
            padding = padding,
            contex = contex,
            navigateToLogin = {
                navigateToLogin()
            }
        )
    }

}

@Composable
fun RegisterForm(
    padding: PaddingValues,
    contex: Context,
    navigateToLogin: () -> Unit
) {

    var nombreCompleto by rememberSaveable { mutableStateOf("") }
    var ciudad by rememberSaveable { mutableStateOf("") }
    var direccion by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val viewModel: AuthViewModel = viewModel()

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
            text = stringResource(id = R.string.titleRegister),
            fontSize = 25.sp,
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Text(
            text = stringResource(id = R.string.subtitleRegisterInformation),
            fontSize = 20.sp,
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = stringResource(id = R.string.subtitleName),
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = nombreCompleto,
            onValueChange = { nombreCompleto = it }
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = stringResource(id = R.string.subtitleCity),
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = ciudad,
            onValueChange = { ciudad = it }
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = stringResource(id = R.string.subtitleStreet),
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = direccion,
            onValueChange = { direccion = it }
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        Text(
            text = stringResource(id = R.string.subtitleRegisterData),
            fontSize = 20.sp,
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = stringResource(id = R.string.subtitleEmail),
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = email,
            onValueChange = { email = it }
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        Text(
            text = stringResource(id = R.string.subtitlePassword),
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = password,
            onValueChange = { password = it }
        )

        Spacer(
            modifier = Modifier
                .height(15.dp)
        )

        Button(
            colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
            onClick = {
                val usuario = Usuario(
                    nombreCompleto = nombreCompleto,
                    ciudad = ciudad,
                    direccion = direccion,
                    email = email,
                    password = password
                )
                viewModel.registrarUsuario(usuario, password)
            }
        ) {
            Text(
                text = stringResource(id = R.string.buttonTextRegister),
                fontSize = 18.sp
            )
        }

        //MUESTRA EL ESTADO DE ÉXITO O ERROR
        viewModel.registroExitoso?.let {
            if (it) {
                Toast.makeText(contex, "Registro exitoso", Toast.LENGTH_LONG).show()
                viewModel.limpiarEstado()
                navigateToLogin()
            }
        }

        viewModel.errorRegistro?.let {
            Text(text = it, color = Color.Red)
            viewModel.limpiarEstado()
        }


        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.textAccount),
                fontSize = 18.sp
            )
            TextButton(
                onClick = {
                    navigateToLogin()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.textEnterHere),
                    fontSize = 18.sp
                )
            }
        }
    }
}