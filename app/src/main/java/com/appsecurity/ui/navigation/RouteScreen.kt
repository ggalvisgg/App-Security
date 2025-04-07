package com.appsecurity.ui.navigation

import kotlinx.serialization.Serializable

sealed class RouteScreen {

//    @Serializable
//    data object Home : RouteScreen()

    @Serializable
    data object Login : RouteScreen()

    @Serializable
    data object Register : RouteScreen()

    @Serializable
    data object ForgetPassword : RouteScreen()

    @Serializable
    data object RecoverPassword : RouteScreen()

    @Serializable
    data object HomeLogueado : RouteScreen()

    @Serializable
    data object WatchAccount : RouteScreen()

    @Serializable
    data object EditInformation : RouteScreen()

    @Serializable
    data object CreateReport : RouteScreen()

    @Serializable
    data object UserReport : RouteScreen()

    @Serializable
    data object UserWatchAllReport : RouteScreen()

    @Serializable
    data object EditReport : RouteScreen()

    @Serializable
    data object InformationAllReport : RouteScreen()

    @Serializable
    data object WatchComents : RouteScreen()

    @Serializable
    data object WatchAllComents : RouteScreen()

    @Serializable
    data object WatchNotification : RouteScreen()

    @Serializable
    data object ReportRelevant : RouteScreen()

    @Serializable
    data object ReportSolved : RouteScreen()

    @Serializable
    data object AllReportsModerator : RouteScreen()

    @Serializable
    data object ReasonReport : RouteScreen()

    @Serializable
    data object ManageReportModerator : RouteScreen()

}