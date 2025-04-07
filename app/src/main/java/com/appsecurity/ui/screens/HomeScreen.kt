package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun HomeScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        HomeForm(
            padding = padding,
            contex = contex
        )
    }

}

@Composable
fun HomeForm(
    padding: PaddingValues,
    contex: Context
){

    Column (
        modifier = Modifier
        .padding()
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text(text = "HOME SIN LOGUEARSE")
    }

}