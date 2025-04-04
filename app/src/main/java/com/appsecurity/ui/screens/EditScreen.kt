package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.stringResource
import com.appsecurity.R
import android.graphics.Color as AndroidColor

@Composable
fun EditScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        EditForm(
            padding = padding,
            contex = contex
        )
    }

}

@Composable
fun EditForm(
    padding: PaddingValues,
    contex: Context
){

    var email by rememberSaveable { mutableStateOf("") }

    Text(text = stringResource(id = R.string.titleEditarInformacion),
        fontSize = 30.sp,
        modifier = Modifier
            .padding(top=80.dp, start = 25.dp))

    Column(
        modifier = Modifier
            .padding(10.dp, top=50.dp)
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
            value = email,
            onValueChange = { email = it },
            label = { Text("Andrea Martina Giraldo") }
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
            value = email,
            onValueChange = { email = it },
            label = { Text("Quimbaya") }
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
            value = email,
            onValueChange = { email = it },
            label = { Text("MZ 4 CRA 3") }
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
            onValueChange = { email = it },
            label = { Text("correo@gmail.com") }
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
            value = email,
            onValueChange = { email = it },
            label = { Text("*********") }
        )

        Spacer(modifier = Modifier
            .height(20.dp))

        Row(
            horizontalArrangement = Arrangement.Start,
                ){

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#7251B5"))),
                onClick = {}
            ) {
                Text(text = stringResource(id = R.string.buttonConfirmar),
                    fontSize = 18.sp)
            }

            Spacer(modifier = Modifier
                .width(10.dp))

            Button(
                colors = ButtonDefaults.buttonColors(Color(AndroidColor.parseColor("#9177C7"))),
                onClick = {}
            ) {
                Text(text = stringResource(id = R.string.buttonCancelar),
                    fontSize = 18.sp)
            }
        }

    }
}

