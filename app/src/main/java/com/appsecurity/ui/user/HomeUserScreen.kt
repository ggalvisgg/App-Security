package com.appsecurity.ui.user

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.appsecurity.ui.user.bottombar.HomeBottomBar
import com.appsecurity.ui.user.navigation.UserNavigation

@Composable
fun HomeUserScreen(
){

    val navController = rememberNavController()

    Scaffold (
        bottomBar = {
            HomeBottomBar(
                navController = navController
            )
        }
    ){ padding ->
        UserNavigation(
            padding = padding,
            navController = navController
        )
    }
}




