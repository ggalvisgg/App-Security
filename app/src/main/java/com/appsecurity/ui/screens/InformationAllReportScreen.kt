package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import android.graphics.Color as AndroidColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.TextToolbar
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InformationAllReportScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        InformationReportForm(
            padding = padding,
            contex = contex
        )
    }
}

@Composable
fun InformationReportForm(
    padding: PaddingValues,
    contex: Context
){

    Column(
        modifier = Modifier
            .padding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        Text(text = "REPORTE",
            fontSize = 30.sp)

        Spacer(modifier = Modifier
            .height(20.dp))

        Text(text = "estrellas",
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 50.dp))

        Spacer(modifier = Modifier
            .height(5.dp))

        Text(text = "Categoria: Mascotas",
            fontSize = 20.sp,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 50.dp))

        Spacer(modifier = Modifier
            .height(5.dp))

        Row {
            Icon(imageVector = Icons.Rounded.AccountBox,
                contentDescription = "Imagen del suceso",
                modifier = Modifier
                    .size(80.dp))

            Icon(imageVector = Icons.Rounded.AccountBox,
                contentDescription = "Imagen del suceso")
        }

        Spacer(modifier = Modifier
            .height(15.dp))

        Row {
            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {}
            ) {
                Text(text = "INFORMACION",
                    fontSize = 15.sp)
            }

            Spacer(modifier = Modifier
                .width(10.dp))

            Button(
                colors = ButtonDefaults.buttonColors(Color.White),
                onClick = {}
            ) {
                Text(text = "COMENTARIOS",
                    fontSize = 18.sp,
                    color = Color.Black)
            }
        }

        Spacer(modifier = Modifier
            .height(20.dp))

        Box {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp) // Agrega espacio entre los elementos
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.Person,
                        contentDescription = "Icono del usuario",
                        modifier = Modifier
                            .size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Maria Garces Hurtado",
                        fontSize = 20.sp)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Rounded.MailOutline,
                        contentDescription = "Icono del detalle del reporte",
                        modifier = Modifier
                            .size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Mascota perdida en las horas de la tarde en el barrio Mariela, iba con un collar color morado",
                        fontSize = 20.sp)
                }
            }
        }

        Spacer(modifier = Modifier
            .height(15.dp))

        Text(text = "AQUI VA EL MAPA")

        Spacer(modifier = Modifier
            .height(15.dp))

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
            ){
            Text(text = "10 personas",
                fontSize = 20.sp)

            Spacer(modifier = Modifier
                .width(5.dp))

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {}
            ) {
                Text(text = "ES RELEVANTE",
                    fontSize = 18.sp)
            }
        }

    }

}