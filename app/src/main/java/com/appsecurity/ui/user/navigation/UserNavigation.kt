package com.appsecurity.ui.user.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.appsecurity.model.Reporte
import com.appsecurity.ui.navigation.RouteScreen
import com.appsecurity.ui.user.screens.EditReportScreen
import com.appsecurity.ui.userModerator.screens.EditScreen
import com.appsecurity.ui.user.screens.InformationAllReportScreen
import com.appsecurity.ui.user.screens.ReportRelevantScreen
import com.appsecurity.ui.user.screens.ReportSolvedScreen
import com.appsecurity.ui.user.screens.UserReportScreen
import com.appsecurity.ui.user.screens.UserWatchAllReportScreen
import com.appsecurity.ui.userModerator.screens.WatchAllComentsScreen
import com.appsecurity.ui.userModerator.screens.WatchComentsScreen
import com.appsecurity.ui.user.tabs.GenerarReporteUserTab
import com.appsecurity.ui.user.tabs.HomeUserTab
import com.appsecurity.ui.user.tabs.NotificacionesUserTab
import com.appsecurity.ui.user.tabs.PerfilUserTab
import com.appsecurity.ui.user.tabs.ReportesUserTab
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

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
            HomeUserTab(
                navigateToInformationAllReport = {
                    navController.navigate(RouteUserTab.InformationAllReport)
                }
            )
        }

        composable<RouteUserTab.Perfil>{
            PerfilUserTab(
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
                    navController.navigate(RouteUserTab.Perfil)
                }
            )
        }

        composable<RouteUserTab.Reportes>{
            ReportesUserTab(
                navigationToReports = {
                    navController.navigate(RouteUserTab.UserReport)
                },
                navigationToReportRelevant = {
                    navController.navigate(RouteUserTab.ReportRelevant)
                },
                navigationToReportSolved = {
                    navController.navigate(RouteUserTab.ReportSolved)
                },
                navigationToInfo = {
                    navController.navigate(RouteUserTab.InformationAllReport)
                }
            )
        }

        composable <RouteUserTab.UserWatchAllReport>{
            UserWatchAllReportScreen(
                navigationToReports = {
                    navController.navigate(RouteUserTab.UserReport)
                },
                navigationToReportRelevant = {
                    navController.navigate(RouteUserTab.ReportRelevant)
                },
                navigationToReportSolved = {
                    navController.navigate(RouteUserTab.ReportSolved)
                },
                navigationToInfo = {
                    navController.navigate(RouteUserTab.InformationAllReport)
                }
            )
        }

        composable <RouteUserTab.UserReport>{
            UserReportScreen(
                navigateToWatchReport = {
                    navController.navigate(RouteUserTab.InformationAllReport)
                },
                navigateToEditReport = { reporte ->
                    val reporteJson = Gson().toJson(reporte)
                    val encodedJson = URLEncoder.encode(reporteJson, StandardCharsets.UTF_8.toString())
                    navController.navigate("${RouteUserTab.EditReport.route}/$encodedJson")
                }
            )
        }

        composable(
            route = RouteUserTab.EditReport.routeWithArgs,
            arguments = listOf(
                navArgument(RouteUserTab.EditReport.reporteArg) { 
                    type = NavType.StringType 
                    nullable = false
                }
            )
        ) { backStackEntry ->
            val reporteJson = backStackEntry.arguments?.getString(RouteUserTab.EditReport.reporteArg)
            val decodedJson = java.net.URLDecoder.decode(reporteJson, StandardCharsets.UTF_8.toString())
            val reporte = Gson().fromJson(decodedJson, Reporte::class.java)
            
            EditReportScreen(
                navigateToReportResuelto = {
                    navController.navigate(RouteUserTab.ReportSolved)
                },
                navigateToReportNoResuelto = {
                    navController.navigate(RouteUserTab.UserWatchAllReport)
                },
                navigateToMyReports = {
                    navController.navigate(RouteUserTab.UserReport)
                },
                reporte = reporte
            )
        }

        composable<RouteUserTab.ReportRelevant>{
            ReportRelevantScreen(
                navigationToInfoReport = {
                    navController.navigate(RouteUserTab.InformationAllReport)
                }
            )
        }

        composable<RouteUserTab.ReportSolved>{
            ReportSolvedScreen()
        }

        composable<RouteUserTab.InformationAllReport>{
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
                    navController.navigate(RouteUserTab.UserReport)
                }
            )
        }

        composable<RouteUserTab.Notificaciones>{
            NotificacionesUserTab()
        }

    }
}
