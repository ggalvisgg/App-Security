package com.appsecurity.ui.moderator.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appsecurity.ui.moderator.HomeModeratorScreen
import com.appsecurity.ui.moderator.tabs.HomeModeratorTab
import com.appsecurity.ui.moderator.tabs.PerfilModeratorTab
import com.appsecurity.ui.moderator.tabs.ReportesModeratorTab
import com.appsecurity.ui.user.navigation.RouteUserTab
import com.appsecurity.ui.user.tabs.HomeUserTab

@Composable
fun ModeratorNavigation(
    padding: PaddingValues,
    navController: NavHostController
){
    NavHost(
        modifier = Modifier.padding(padding),
        navController = navController,
        startDestination = RouteModerator.Home
    ){
        composable<RouteModerator.Home>{
            HomeModeratorTab()
        }

        composable<RouteModerator.Reportes>{
            ReportesModeratorTab()
        }

        composable<RouteModerator.Perfil>{
            PerfilModeratorTab()
        }
    }
}