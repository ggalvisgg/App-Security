package com.appsecurity.ui.user.screens

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.appsecurity.viewmodel.ReporteViewModel
import android.graphics.Color as AndroidColor
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import androidx.compose.material3.AlertDialog

@Composable
fun UserReportScreen(
    navigateToWatchReport : () -> Unit,
    navigateToEditReport : () -> Unit
){

    var contex = LocalContext.current

    Scaffold { padding ->
        ReportForm(
            padding = padding,
            contex = contex,
            navigateToWatchReport = {
                navigateToWatchReport()
            },
            navigateToEditReport = {
                navigateToEditReport()
            }
        )
    }
}

@Composable
fun ReportForm(
    padding: PaddingValues,
    contex: Context,
    navigateToWatchReport: () -> Unit,
    navigateToEditReport: () -> Unit
) {

    val viewModel: ReporteViewModel = viewModel()
    val reportes = viewModel.listaMisReportes
    var showDialog by remember { mutableStateOf(false) }

    // Obtener los reportes al entrar en la pantalla
    LaunchedEffect(Unit) {
        viewModel.obtenerMisReportes()
    }

    if (reportes.isEmpty()) {
        Text("No tienes reportes aún")
    }

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.titleMisReportes),
            fontSize = 30.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn {
            items(reportes) { reporte ->
                Box(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        AsyncImage(
                            model = reporte.urlImagen,
                            contentDescription = "Imagen del reporte",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = reporte.categoria.name,
                            modifier = Modifier.align(Alignment.Start),
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = reporte.descripcion,
                            modifier = Modifier.align(Alignment.Start),
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(onClick = { navigateToEditReport() }) {
                                Icon(
                                    imageVector = Icons.Rounded.Edit,
                                    contentDescription = "Editar",
                                    modifier = Modifier.size(30.dp),
                                    tint = Color(0xFF9177C7)
                                )
                            }

                            IconButton(onClick = { showDialog = true }) {
                                Icon(
                                    imageVector = Icons.Rounded.Delete,
                                    contentDescription = "Eliminar",
                                    modifier = Modifier.size(30.dp),
                                    tint = Color(0xFF63578A)
                                )
                            }

                            Button(
                                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                                onClick = {
                                    showDialog = true
                                }
                            ) {
                                Text(
                                    text = stringResource(id = R.string.buttonVer),
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }
                }

                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        confirmButton = {
                            TextButton(onClick = {
                                viewModel.eliminarReporte(reporte.id,
                                    onSuccess = {
                                        Toast.makeText(contex, "Reporte eliminado", Toast.LENGTH_SHORT).show()
                                        showDialog = false
                                    },
                                    onError = {
                                        Toast.makeText(contex, it, Toast.LENGTH_LONG).show()
                                        showDialog = false
                                    }
                                )
                            }) {
                                Text("Sí, eliminar")
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDialog = false }) {
                                Text("Cancelar")
                            }
                        },
                        title = { Text("¿Eliminar reporte?") },
                        text = { Text("¿Estás seguro de que deseas eliminar este reporte? Esta acción no se puede deshacer.") }
                    )
                }
            }
        }
    }
}


