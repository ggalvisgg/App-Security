package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ManageReportModeratorScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        ManageReportModeratorForm(
            padding = padding,
            contex = contex
        )
    }
}

@Composable
fun ManageReportModeratorForm(
    padding: PaddingValues,
    contex: Context
){
//DE ULTIMA
}