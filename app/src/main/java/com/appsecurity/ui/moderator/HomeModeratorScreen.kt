package com.appsecurity.ui.moderator

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.appsecurity.ui.moderator.navigation.ModeratorNavigation
import com.appsecurity.ui.moderator.bottombar.HomeBottomBar


@Composable
fun HomeModeratorScreen(
){

    val navController = rememberNavController()

    Scaffold (
        bottomBar = {
            HomeBottomBar(
                navController = navController
            )
        }
    ){ padding ->
        ModeratorNavigation(
            padding = padding,
            navController = navController
        )
    }
}