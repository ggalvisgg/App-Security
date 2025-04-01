package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalAutofill
import androidx.compose.ui.platform.LocalContext

@Composable
fun UserCreateReportScreen(){

    var contex = LocalContext.current

    Scaffold { padding ->
        CreateReportForm(
            padding,
            contex
        )
    }
}

@Composable
fun CreateReportForm(
    paddingValues: PaddingValues,
    contex : Context
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Categoria")

    }
}