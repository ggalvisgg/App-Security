package com.appsecurity.ui.moderator.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appsecurity.ui.moderator.tabs.HomeModeratorTab
import com.appsecurity.ui.moderator.tabs.PerfilModeratorTab
import com.appsecurity.ui.moderator.tabs.ReportesModeratorTab
import com.appsecurity.ui.navigation.RouteScreen
import com.appsecurity.ui.screens.EditScreen
import com.appsecurity.ui.screens.ManageReportModeratorScreen
import com.appsecurity.ui.screens.ReasonReportScreen
import com.appsecurity.ui.screens.ReportSolvedScreen
import com.appsecurity.ui.screens.WatchAllComentsScreen
import com.appsecurity.ui.screens.WatchComentsScreen
import com.appsecurity.ui.user.navigation.RouteUserTab

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
            ReportesModeratorTab(
                navigationToInfoReportModerator = {
                    navController.navigate(RouteScreen.ManageReportModerator)
                },
                navigationToReasonReport = {
                    navController.navigate(RouteScreen.ReasonReport)
                }
            )
        }

        composable<RouteModerator.Perfil>{
            PerfilModeratorTab(
                navigationToEdit = {
                    navController.navigate(RouteScreen.EditInformation)
                }
            )
        }

        composable<RouteScreen.EditInformation>{
            EditScreen (
                navigationToAccount = {
                    navController.navigate(RouteModerator.Perfil)
                }
            )
        }

        composable<RouteScreen.ManageReportModerator>{
            navController.navigate(RouteScreen.ManageReportModerator)
        }

        composable<RouteScreen.ManageReportModerator>{
            ManageReportModeratorScreen(
                navigationToComents ={
                    navController.navigate(RouteScreen.WatchComents)
                },
                navigationToResuelto = {
                    navController.navigate(RouteScreen.ReportSolved)
                }
            )
        }

        composable<RouteScreen.WatchComents>{
            WatchComentsScreen(
                navigationToAllComents = {
                    navController.navigate(RouteScreen.WatchAllComents)
                }
            )
        }

        composable<RouteScreen.ReportSolved>{
            ReportSolvedScreen()
        }

        composable<RouteScreen.WatchAllComents>{
            WatchAllComentsScreen()
        }

        composable<RouteScreen.ReasonReport>{
            ReasonReportScreen(
                navegationToReportes = {
                    navController.navigate(RouteModerator.Reportes)
                }
            )
        }

    }
}