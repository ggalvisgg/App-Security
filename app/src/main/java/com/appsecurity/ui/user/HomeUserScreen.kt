package com.appsecurity.ui.user

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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




