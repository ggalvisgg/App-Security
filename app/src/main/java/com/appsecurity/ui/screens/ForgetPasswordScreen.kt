package com.appsecurity.ui.screens

import android.content.Context
import android.widget.Toast
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appsecurity.R
import com.appsecurity.viewmodel.AuthViewModel
import android.graphics.Color as AndroidColor

@Composable
fun ForgetPasswordScreen(
    navigateToLogin: () -> Unit
){

    val contex = LocalContext.current

    Scaffold { padding ->
        ForgetPassForm(
            padding = padding,
            contex = contex,
            navigateToLogin = navigateToLogin
        )
    }
}

@Composable
fun ForgetPassForm(
    padding: PaddingValues,
    contex: Context,
    navigateToLogin: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    val viewModel: AuthViewModel = viewModel()

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.titleForgetPassword),
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = stringResource(id = R.string.subtitleRecuperarContraseña),
            fontSize = 23.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(id = R.string.textCorreo),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("correo@ejemplo.com") }
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
            onClick = {
                if (email.isNotBlank()) {
                    viewModel.recuperarContrasenia(
                        email = email,
                        onSuccess = {
                            Toast.makeText(contex, "Correo enviado con instrucciones", Toast.LENGTH_LONG).show()
                            navigateToLogin()
                        },
                        onError = {
                            Toast.makeText(contex, it, Toast.LENGTH_LONG).show()
                        }
                    )
                } else {
                    Toast.makeText(contex, "Ingresa tu correo", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(
                text = stringResource(id = R.string.buttonCorreo),
                fontSize = 18.sp
            )
        }
    }
}
