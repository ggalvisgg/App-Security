package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.background
import android.graphics.Color as AndroidColor
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
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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

@Composable
fun ReportRelevantScreen(
    navigationToInfoReport : () -> Unit
){

    val contex = LocalContext.current

    Scaffold { padding ->
        RelevantForm(
            padding = padding,
            contex = contex,
            navigationToInfoReport = {
                navigationToInfoReport()
            }
        )
    }
}

@Composable
fun RelevantForm(
    padding: PaddingValues,
    contex: Context,
    navigationToInfoReport : () -> Unit
){

    Column(
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(id = R.string.titleReporteRelevante),
            fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "estrellas",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Categoria: Mascotas",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.AccountBox,
                        contentDescription = stringResource(id = R.string.textIconImagenSuceso),
                        modifier = Modifier.size(80.dp)
                    )

                    Icon(
                        imageVector = Icons.Rounded.AccountBox,
                        contentDescription = stringResource(id = R.string.textIconImagenSuceso),
                        modifier = Modifier.size(80.dp)
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = "Mascota perdida en las horas de la mañana en el barrio Mariela",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                    onClick = {
                        navigationToInfoReport()
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.buttonVer),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}