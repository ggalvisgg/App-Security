package com.appsecurity.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign

@Composable
fun WatchComentsScreen(){

    val contex = LocalContext.current

    Scaffold { padding ->
        WatchComentsForm(
            padding = padding,
            contex = contex
        )
    }
}

@Composable
fun WatchComentsForm(
    padding: PaddingValues,
    contex: Context
){

}