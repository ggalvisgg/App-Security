package com.appsecurity.ui.user.screens

import android.content.Context
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsecurity.R
import android.graphics.Color as AndroidColor

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
    padding : PaddingValues,
    contex : Context,
    navigateToWatchReport : () -> Unit,
    navigateToEditReport : () -> Unit
){
    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = stringResource(id = R.string.titleMisReportes),
            fontSize = 30.sp)

        Spacer(modifier = Modifier
            .height(20.dp))

        Box(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(imageVector = Icons.Rounded.Done,
                    contentDescription = stringResource(id = R.string.imagenReporte),
                    modifier = Modifier
                        .size(20.dp)
                        .align(Alignment.End)
                )

                Icon(
                    imageVector = Icons.Rounded.CheckCircle,
                    contentDescription = stringResource(id = R.string.textIconoVerificacion),
                    modifier = Modifier
                        .size(50.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Mascotas",
                    modifier = Modifier.align(Alignment.Start),
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Mascota perdida en las horas de la mañana en el barrio Mariela",
                    modifier = Modifier.align(Alignment.Start),
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(onClick = {
                        navigateToEditReport()
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Edit,
                            contentDescription = stringResource(id = R.string.textIconoVerificacion),
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .size(30.dp),
                            tint = Color(0xFF9177C7)
                        )
                    }

                    Icon(
                        imageVector = Icons.Rounded.Delete,
                        contentDescription = stringResource(id = R.string.textIconoEliminar),
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(30.dp),
                        tint = Color(0xFF63578A)
                    )

                    Button(
                        colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                        onClick = {
                            navigateToWatchReport()
                        }
                    ) {
                        Text(
                            text = stringResource(id = R.string.buttonVer),
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}