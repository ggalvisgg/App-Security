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
import com.appsecurity.ui.userModerator.screens.EditScreen
import com.appsecurity.ui.moderator.screens.ManageReportModeratorScreen
import com.appsecurity.ui.moderator.screens.ReasonReportScreen
import com.appsecurity.ui.user.navigation.RouteUserTab
import com.appsecurity.ui.user.screens.ReportSolvedScreen
import com.appsecurity.ui.userModerator.screens.WatchAllComentsScreen
import com.appsecurity.ui.userModerator.screens.WatchComentsScreen

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
                    navController.navigate(RouteModerator.ManageReport)
                },
                navigationToReasonReport = {
                    navController.navigate(RouteModerator.ReasonReport)
                }
            )
        }

        composable<RouteModerator.Perfil>{
            PerfilModeratorTab(
                navigationToEdit = {
                    navController.navigate(RouteScreen.EditInformation)
                },
                navigationToLogin = {
                    navController.navigate(RouteScreen.Login)
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

        composable<RouteModerator.ManageReport>{
            navController.navigate(RouteModerator.ManageReport)
        }

        composable<RouteModerator.ManageReport>{
            ManageReportModeratorScreen(
                navigationToComents ={
                    navController.navigate(RouteScreen.WatchComents)
                },
                navigationToResuelto = {
                    navController.navigate(RouteUserTab.ReportSolved)
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

        composable<RouteUserTab.ReportSolved>{
            ReportSolvedScreen()
        }

        composable<RouteScreen.WatchAllComents>{
            WatchAllComentsScreen()
        }

        composable<RouteModerator.ReasonReport>{
            ReasonReportScreen(
                navegationToReportes = {
                    navController.navigate(RouteModerator.Reportes)
                }
            )
        }

    }
}