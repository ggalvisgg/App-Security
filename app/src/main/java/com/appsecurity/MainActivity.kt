package com.appsecurity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.appsecurity.ui.screens.EditScreen
import com.appsecurity.ui.screens.LoginScreen
import com.appsecurity.ui.screens.ManageReportModeratorScreen
import com.appsecurity.ui.screens.ReasonReportScreen
import com.appsecurity.ui.screens.RecoverPasswordScreen
import com.appsecurity.ui.screens.RegisterUserScreen
import com.appsecurity.ui.screens.WatchAllComentsScreen
import com.appsecurity.ui.screens.WatchComentsScreen
import com.appsecurity.ui.screens.WatchNotificationScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //LoginScreen()
            //EditScreen()
            //RecoverPasswordScreen()
            //WatchNotificationScreen()
            //ReasonReportScreen()
            //ManageReportModeratorScreen() -> ESTA DE ULTIMA
            //WatchComentsScreen() -> ESTA DE ULTIMA
            //WatchAllComentsScreen()
            RegisterUserScreen()
        }
    }
}

