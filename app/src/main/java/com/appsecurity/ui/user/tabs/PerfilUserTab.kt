package com.appsecurity.ui.user.tabs

import android.widget.Toast
import android.graphics.Color as AndroidColor
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.appsecurity.R
import com.appsecurity.viewmodel.UsuarioViewModel

@Composable
fun PerfilUserTab(
    navigationToEdit: () -> Unit,
    navigationToLogin: () -> Unit
){

    val viewModel : UsuarioViewModel = viewModel()
    val usuario = viewModel.usuario
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }


    val nombreCompleto = usuario?.nombreCompleto?:""
    val ciudad = usuario?.ciudad?: ""
    val direccion = usuario?.direccion?: ""
    val email = usuario?.email?: ""
    val password = usuario?.password?: ""

    Column(
        modifier = Modifier
            .padding()
            .fillMaxSize(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(id = R.string.titleCuenta),
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier
            .height(15.dp))

        Icon(
            imageVector = Icons.Rounded.AccountCircle,
            contentDescription = stringResource(id = R.string.textIconUsuario),
            Modifier.size(80.dp))

        Spacer(modifier = Modifier
            .height(15.dp))

        Text(
            text = stringResource(id = R.string.subtitleName),
            fontSize = 18.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 60.dp, bottom = 10.dp)
        )

        TextField(
            value = nombreCompleto,
            onValueChange = {},
            readOnly = true,
            enabled = false
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
            onValueChange = {  },
            readOnly = true,
            enabled = false
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
            onValueChange = {  },
            readOnly = true,
            enabled = false
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
            onValueChange = { },
            readOnly = true,
            enabled = false
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
            onValueChange = {  },
            readOnly = true,
            enabled = false
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
        )

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    TextButton(onClick = {
                        showDialog = false
                        viewModel.eliminarCuenta()
                    }) {
                        Text("Sí")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showDialog = false
                    }) {
                        Text("Cancelar")
                    }
                },
                title = { Text("Confirmar eliminación") },
                text = { Text("¿Estás seguro de que deseas eliminar tu cuenta? Esta acción no se puede deshacer.") }
            )
        }

        // Detectar éxito o error
        if (viewModel.eliminacionExitosa) {
            Toast.makeText(context, "Cuenta eliminada", Toast.LENGTH_SHORT).show()
            viewModel.limpiarEstadoEliminacion()
            navigationToLogin()
        }

        viewModel.errorEliminacion?.let {
            Toast.makeText(context, it, Toast.LENGTH_LONG).show()
            viewModel.limpiarEstadoEliminacion()
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {
                    navigationToEdit()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.subtitleEditarInformacion),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#9177C7"))),
                onClick = {
                    showDialog = true
                }
            ) {
                Text(
                    text = stringResource(id = R.string.subtitleEliminarCuenta),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}