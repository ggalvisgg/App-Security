package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

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
    Text(text = "EDITAR \nINFORMACION")
}

