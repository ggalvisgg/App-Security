package com.appsecurity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.appsecurity.ui.screens.EditReportScreen
import com.appsecurity.ui.screens.EditScreen
import com.appsecurity.ui.screens.ForgetPasswordScreen
import com.appsecurity.ui.screens.InformationAllReportScreen
import com.appsecurity.ui.screens.LoginScreen
import com.appsecurity.ui.screens.ManageReportModeratorScreen
import com.appsecurity.ui.screens.ReasonReportScreen
import com.appsecurity.ui.screens.RecoverPasswordScreen
import com.appsecurity.ui.screens.RegisterUserScreen
import com.appsecurity.ui.screens.ReportRelevantScreen
import com.appsecurity.ui.screens.ReportSolvedScreen
import com.appsecurity.ui.screens.UserCreateReportScreen
import com.appsecurity.ui.screens.UserReportScreen
import com.appsecurity.ui.screens.UserWatchAllReportScreen
import com.appsecurity.ui.screens.WatchAccountScreen
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
            //ManageReportModeratorScreen()
            //WatchComentsScreen()
            //WatchAllComentsScreen()
            //RegisterUserScreen()
            //ForgetPasswordScreen()
            //WatchAccountScreen()
            //UserReportScreen()
            //UserWatchAllReportScreen()
            //UserCreateReportScreen()
            //EditReportScreen()
            //InformationAllReportScreen()
            //ReportRelevantScreen()
            //ReportSolvedScreen()
        }
    }
}

