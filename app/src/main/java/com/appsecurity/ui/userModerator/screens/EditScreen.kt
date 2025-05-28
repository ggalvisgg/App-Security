package com.appsecurity.ui.userModerator.screens

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appsecurity.R
import com.appsecurity.viewmodel.UsuarioViewModel
import android.graphics.Color as AndroidColor

@Composable
fun EditScreen(navigationToAccount: () -> Unit){

    val contex = LocalContext.current

    Scaffold { padding ->
        EditForm(
            padding = padding,
            contex = contex,
            navigationToAccount = {
                navigationToAccount()
            }
        )
    }
}

@Composable
fun EditForm(
    padding: PaddingValues,
    contex: Context,
    navigationToAccount : () -> Unit
){

    val viewModel : UsuarioViewModel = viewModel()
    val usuario = viewModel.usuario

    var nombreCompleto by rememberSaveable { mutableStateOf("") }
    var ciudad by rememberSaveable { mutableStateOf("") }
    var direccion by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(usuario) {
        usuario?.let {
            nombreCompleto = it.nombreCompleto
            ciudad = it.ciudad
            direccion = it.direccion
            email = it.email
            password = it.password
        }
    }

    Row(
        modifier = Modifier.padding(top = 80.dp, start = 25.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(id = R.string.titleEditarInformacion),
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.width(80.dp))

        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = stringResource(id = R.string.textIconoEditar),
            modifier = Modifier.size(50.dp)

        )
    }

    Spacer(modifier = Modifier.width(10.dp))

    Column(
        modifier = Modifier
            .padding(10.dp, top=100.dp)
            .fillMaxSize(),
        //verticalArrangement = Arrangement.Top,
        //verticalArrangement = Arrangement.Center
        //horizontalAlignment = Alignment.Start
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = stringResource(id = R.string.subtitleName),
            fontSize = 18.sp,
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = nombreCompleto,
            onValueChange = { nombreCompleto = it }
        )

        Spacer(modifier = Modifier
            .height(10.dp))

        Text(text = stringResource(id = R.string.subtitleCity),
            fontSize = 18.sp,
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = ciudad,
            onValueChange = { ciudad = it }
        )

        Spacer(modifier = Modifier
            .height(10.dp))

        Text(text = stringResource(id = R.string.subtitleStreet),
            fontSize = 18.sp,
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = direccion,
            onValueChange = { direccion = it }
        )

        Spacer(modifier = Modifier
            .height(10.dp))

        Text(text = stringResource(id = R.string.subtitleEmail),
            fontSize = 18.sp,
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = email,
            onValueChange = { email = it }
        )

        Spacer(modifier = Modifier
            .height(10.dp))

        Text(text = stringResource(id = R.string.subtitlePassword),
            fontSize = 18.sp,
            modifier = Modifier
                .align (Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = password,
            onValueChange = { password = it }
        )

        Spacer(modifier = Modifier
            .height(20.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
                ){

            Button(
                onClick = {
                    viewModel.actualizarUsuario(nombreCompleto, ciudad, direccion, email, password)
                },
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5")))
            ) {
                Text("Confirmar")
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    navigationToAccount()
                },
                colors = ButtonDefaults.buttonColors(Color.Gray)
            ) {
                Text("Cancelar")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Mostrar éxito o error
        if (viewModel.actualizacionExitosa) {
            Toast.makeText(contex, "Información actualizada", Toast.LENGTH_SHORT).show()
            viewModel.limpiarEstados()
            navigationToAccount()
        }

        viewModel.errorActualizacion?.let {
            Text(it, color = Color.Red)
        }
    }
}

