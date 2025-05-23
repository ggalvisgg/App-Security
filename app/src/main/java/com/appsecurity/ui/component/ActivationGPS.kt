package com.appsecurity.ui.component

import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
fun ActivationGps(){

    val context = LocalContext.current

    val permission = android.Manifest.permission.ACCESS_FINE_LOCATION

    var hasPermission by remember {
        mutableStateOf(ContextCompat.checkSelfPermission(context, permission) ==
                PackageManager.PERMISSION_GRANTED)
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) {
            isGranted ->
        hasPermission = isGranted

        if(isGranted){
            Toast.makeText(context, "Permiso concedido", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(context, "Permiso denegado", Toast.LENGTH_LONG).show()
        }
    }

    LaunchedEffect(Unit) {
        if(!hasPermission){
            permissionLauncher.launch(permission)
        }
    }

}