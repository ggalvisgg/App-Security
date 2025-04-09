package com.appsecurity.ui.user.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambdaN
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appsecurity.ui.navigation.RouteScreen
import com.appsecurity.ui.screens.EditForm
import com.appsecurity.ui.screens.EditScreen
import com.appsecurity.ui.screens.InformationAllReportScreen
import com.appsecurity.ui.screens.ReportRelevantScreen
import com.appsecurity.ui.screens.ReportSolvedScreen
import com.appsecurity.ui.screens.UserReportScreen
import com.appsecurity.ui.screens.UserWatchAllReportScreen
import com.appsecurity.ui.screens.WatchAllComentsScreen
import com.appsecurity.ui.screens.WatchComentsScreen
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
            PerfilUserTab(
                navigationToEdit = {
                    navController.navigate(RouteScreen.EditInformation)
                }
            )
        }

        composable<RouteScreen.EditInformation>{
            EditScreen (
                navigationToAccount = {
                    navController.navigate(RouteUserTab.Perfil)
                }
            )
        }

        composable<RouteUserTab.Reportes>{
            ReportesUserTab(
                navigationToReports = {
                    navController.navigate(RouteScreen.UserReport)
                },
                navigationToReportRelevant = {
                    navController.navigate(RouteScreen.ReportRelevant)
                },
                navigationToReportSolved = {
                    navController.navigate(RouteScreen.ReportSolved)
                },
                navigationToInfo = {
                    navController.navigate(RouteScreen.InformationAllReport)
                }
            )
        }

        composable <RouteScreen.UserWatchAllReport>{
            UserWatchAllReportScreen(
                navigationToReports = {
                    navController.navigate(RouteScreen.UserReport)
                },
                navigationToReportRelevant = {
                    navController.navigate(RouteScreen.ReportRelevant)
                },
                navigationToReportSolved = {
                    navController.navigate(RouteScreen.ReportSolved)
                },
                navigationToInfo = {
                    navController.navigate(RouteScreen.InformationAllReport)
                }
            )
        }

        composable <RouteScreen.UserReport>{
            UserReportScreen(
                navigateToWatchReport = {
                    navController.navigate(RouteScreen.InformationAllReport)
                }
            )
        }

        composable<RouteScreen.ReportRelevant>{
            ReportRelevantScreen(
                navigationToInfoReport = {
                    navController.navigate(RouteScreen.InformationAllReport)
                }
            )
        }

        composable<RouteScreen.ReportSolved>{
            ReportSolvedScreen()
        }

        composable<RouteScreen.InformationAllReport>{
            InformationAllReportScreen(
                navigationToComents = {
                    navController.navigate(RouteScreen.WatchComents)
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

        composable<RouteScreen.WatchAllComents>{
            WatchAllComentsScreen()
        }

        composable<RouteUserTab.GenerarReporte>{
            GenerarReporteUserTab(
                navigateToHome = {
                    navController.navigate(RouteScreen.HomeLogueadoUser)
                },
                navigateToUserReport = {
                    navController.navigate(RouteScreen.UserReport)
                }
            )
        }

        composable<RouteUserTab.Notificaciones>{
            NotificacionesUserTab()
        }

    }
}
