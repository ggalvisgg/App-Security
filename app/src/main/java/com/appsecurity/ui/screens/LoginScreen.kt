package com.appsecurity.ui.screens

import androidx.compose.runtime.Composable
import android.content.Context
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.createBitmap
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appsecurity.R
import com.appsecurity.ui.component.ButtonIcon
import com.appsecurity.ui.component.TextFieldForm
import com.appsecurity.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    navigateToSingUp : () -> Unit,
    navigateToPasswordForget: () -> Unit,
    navigateToHomeUser : () -> Unit,
    navigateToHomeModerator: () -> Unit
){

    val contex = LocalContext.current

    Scaffold { padding ->
        LoginForm(
            padding = padding,
            contex = contex,
            navigateToSingUp = {
                navigateToSingUp()
            },
            navigateToPasswordForget = {
                navigateToPasswordForget()
            },
            navigateToHomeUser =  {
                navigateToHomeUser()
            },
            navigateToHomeModerator = {
                navigateToHomeModerator()
            }
        )
    }
}

@Composable
fun LoginForm(
    padding: PaddingValues,
    contex: Context,
    navigateToSingUp: () -> Unit,
    navigateToPasswordForget: () -> Unit,
    navigateToHomeUser: () -> Unit,
    navigateToHomeModerator: () -> Unit
){

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val viewModel: AuthViewModel = viewModel()

    Column(
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = stringResource(id = R.string.titleLogin),
            fontSize = 25.sp)

        Image(
            bitmap = ImageBitmap.imageResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.textIconApp),
            modifier = Modifier
                .padding(50.dp)
        )

        Text(text = stringResource(id = R.string.subtitleEmail),
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 70.dp)
        )

        TextFieldForm(
            value = email,
            onValueChange = {
                email = it
            },
            supportingText = "El correo no es valido",
            placeholder = "email@gmail.com",

            //Toda la logica de validacion va aqui
            onValidate = {
                !Patterns.EMAIL_ADDRESS.matcher(it).matches()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = stringResource(id = R.string.subtitlePassword),
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

        TextButton(
            modifier = Modifier
                .align(Alignment.End)
                .padding(end=20.dp),
            onClick = {
                navigateToPasswordForget()
            }
        ) {
            Text(
                text = stringResource(id = R.string.textForgetPassword)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        ButtonIcon(
            icon = Icons.Rounded.Done,
            text = stringResource(id = R.string.textIconLogin),
            onClick = {
                viewModel.login(email, password)
//                if(email =="gabriela@gmail.com" && password=="12345678"){
//                    Toast.makeText(contex, "Bienvenido", Toast.LENGTH_SHORT).show()
//                    navigateToHomeUser()
//                }else if(email =="admi@gmail.com" && password=="12345678"){
//                    Toast.makeText(contex, "Bienvenido admi", Toast.LENGTH_SHORT).show()
//                    navigateToHomeModerator()
//                }else{
//                    Toast.makeText(contex, "Correo o contraseña incorrecta", Toast.LENGTH_SHORT).show()
//                }
            },
            color = "#7251B5",
            enable = email.isNotEmpty() && password.isNotEmpty()
        )

        viewModel.loginExitoso?.let { success ->
            if (success) {
                val tipo = viewModel.tipoUsuario
                if (tipo == "MODERADOR") {
                    Toast.makeText(contex, "Bienvenido moderador", Toast.LENGTH_SHORT).show()
                    viewModel.limpiarEstado()
                    navigateToHomeModerator()
                } else {
                    Toast.makeText(contex, "Bienvenido", Toast.LENGTH_SHORT).show()
                    viewModel.limpiarEstado()
                    navigateToHomeUser()
                }
            }
        }

        viewModel.errorLogin?.let {
            Toast.makeText(contex, it, Toast.LENGTH_LONG).show()
            viewModel.limpiarEstado()
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.textNoAccount)
            )

            TextButton(
                onClick = {
                    navigateToSingUp()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.textRegister)
                )
            }
        }
    }
}