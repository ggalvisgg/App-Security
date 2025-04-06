package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun AllReportsModeratorScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        AllReportsForm(
            padding = padding,
            contex = contex
        )
    }

}

@Composable
fun AllReportsForm(
    padding: PaddingValues,
    contex: Context
){

}