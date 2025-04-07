package com.appsecurity.ui.user.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appsecurity.ui.user.tabs.GenerarReporteUserTab
import com.appsecurity.ui.user.tabs.HomeUserTab
import com.appsecurity.ui.user.tabs.NotificacionesUserTab
import com.appsecurity.ui.user.tabs.PerfilUserTab
import com.appsecurity.ui.user.tabs.ReportesUserTab

@Composable
fun UserNavigation(
    padding: PaddingValues,
    navController: NavHostController
){

    NavHost(
        modifier = Modifier.padding(padding),
        navController = navController,
        startDestination = RouteUserTab.Home
    ){

        composable<RouteUserTab.Home>{
            HomeUserTab()
        }

        composable<RouteUserTab.Perfil>{
            PerfilUserTab()
        }

        composable<RouteUserTab.Reportes>{
            ReportesUserTab()
        }

        composable<RouteUserTab.GenerarReporte>{
            GenerarReporteUserTab()
        }

        composable<RouteUserTab.Notificaciones>{
            NotificacionesUserTab()
        }

    }
}
