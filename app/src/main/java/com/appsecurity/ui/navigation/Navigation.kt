package com.appsecurity.ui.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appsecurity.ui.moderator.HomeModeratorScreen
//import com.appsecurity.ui.moderator.screens.AllReportsModeratorScreen
import com.appsecurity.ui.user.screens.EditReportScreen
import com.appsecurity.ui.userModerator.screens.EditScreen
import com.appsecurity.ui.screens.ForgetPasswordScreen
import com.appsecurity.ui.user.HomeUserScreen
import com.appsecurity.ui.user.screens.InformationAllReportScreen
import com.appsecurity.ui.screens.LoginScreen
import com.appsecurity.ui.screens.RecoverPasswordScreen
import com.appsecurity.ui.screens.RegisterUserScreen
import com.appsecurity.ui.userModerator.screens.WatchAllComentsScreen
import com.appsecurity.ui.userModerator.screens.WatchComentsScreen
//import com.appsecurity.ui.screens.WatchNotificationScreen
import com.appsecurity.ui.moderator.navigation.RouteModerator

@Composable
fun Navigation(){

    val navController = rememberNavController()

    //Esto es para que el celular se adapte si lo cambiamos al tema oscuro
    Surface {
        NavHost(
            navController = navController,
            startDestination = RouteScreen.Login
        ) {

            composable<RouteScreen.Login>{
                LoginScreen(
                    navigateToSingUp = {
                        navController.navigate(RouteScreen.Register)
                    },
                    navigateToPasswordForget = {
                        navController.navigate(RouteScreen.ForgetPassword)
                    },
                    navigateToHomeUser = {
                        navController.navigate(RouteScreen.HomeLogueadoUser)
                    },
                    navigateToHomeModerator = {
                        navController.navigate(RouteScreen.HomeLogueadoAdmi)
                    }
                )
            }

            composable<RouteScreen.Register>{
                RegisterUserScreen(
                    navigateToLogin = {
                        navController.navigate(RouteScreen.Login)
                    }
                )
            }

            composable<RouteScreen.ForgetPassword>{
                ForgetPasswordScreen(
                    navigateToLogin = {
                        navController.navigate(RouteScreen.Login)
                    }
                )
            }

            composable<RouteScreen.RecoverPassword>{
                RecoverPasswordScreen()
            }

            composable<RouteScreen.HomeLogueadoUser>{
                HomeUserScreen()
            }

            composable<RouteScreen.HomeLogueadoAdmi>{
                HomeModeratorScreen()
            }

//            composable<RouteScreen.WatchAccount>{
//                WatchAccountScreen(
//                    navigationToEdit = {
//                        navController.navigate(RouteScreen.EditInformation)
//                    }
//                )
//            }

            composable<RouteScreen.EditInformation>{
                EditScreen(
                    navigationToAccount = {
                        navController.navigate(RouteScreen.WatchAccount)
                    }
                )
            }

//            composable<RouteScreen.CreateReport>{
//                UserCreateReportScreen(
//                    navigateToHome = {
//                        navController.navigate(RouteScreen.HomeLogueadoUser)
//                    },
//                    navigateToUserReport = {
//                        navController.navigate(RouteScreen.UserReport)
//                    }
//                )
//            }

//            composable<RouteScreen.UserReport>{
//                UserReportScreen(
//                    navigateToWatchReport = {
//                        navController.navigate(RouteScreen.InformationAllReport)
//                    }
//                )
//            }

//            composable<RouteScreen.UserWatchAllReport>{
//                UserWatchAllReportScreen(
//                    navigationToReports = {
//                        navController.navigate(RouteScreen.UserReport)
//                    },
//                    navigationToReportRelevant = {
//                        navController.navigate(RouteScreen.ReportRelevant)
//                    } ,
//                    navigationToReportSolved = {
//                        navController.navigate(RouteScreen.ReportSolved)
//                    },
//                    navigationToInfo = {
//                        navController.navigate(RouteScreen.InformationAllReport)
//                    }
//                )
//            }

//            composable<RouteScreen.EditReport>{
//                EditReportScreen(
//                    navigateToReportResuelto = {
//                        navController.navigate(RouteScreen.ReportSolved)
//                    },
//                    navigateToReportNoResuelto = {
//                        navController.navigate(RouteScreen.UserWatchAllReport)
//                    },
//                    navigateToMyReports = {
//                        navController.navigate(RouteScreen.UserReport)
//                    }
//                )
//            }

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

//            composable<RouteScreen.WatchNotification>{
//                WatchNotificationScreen()
//            }

//            composable<RouteScreen.ReportRelevant>{
//                ReportRelevantScreen(
//                    navigationToInfoReport = {
//                        navController.navigate(RouteScreen.InformationAllReport)
//                    }
//                )
//            }

//            composable<RouteScreen.ReportSolved>{
//                ReportSolvedScreen()
//            }

//            composable<RouteScreen.AllReportsModerator>{
//                AllReportsModeratorScreen(
//                    navigationToInfoReportModerator = {
//                        navController.navigate(RouteScreen.ManageReportModerator)
//                    }
//                )
//            }

//            composable<RouteScreen.ReasonReport>{
//                ReasonReportScreen(
//                    navegationToReportes = {
//                        navController.navigate(RouteModerator.Reportes)
//                    }
//                )
//            }

//            composable<RouteScreen.ManageReportModerator>{
//                ManageReportModeratorScreen(
//                    navigationToComents = {
//                        navController.navigate(RouteScreen.WatchComents)
//                    },
//                    navigationToResuelto = {
//                        navController.navigate(RouteScreen.ReportSolved)
//                    }
//                )
//            }

        }

    }


}