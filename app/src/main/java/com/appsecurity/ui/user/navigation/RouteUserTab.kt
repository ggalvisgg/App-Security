package com.appsecurity.ui.user.navigation

import com.appsecurity.ui.navigation.RouteScreen
import kotlinx.serialization.Serializable

sealed class RouteUserTab {

    @Serializable
    data object Notificaciones : RouteUserTab()

    @Serializable
    data object Reportes : RouteUserTab()

    @Serializable
    data object Home : RouteUserTab()

    @Serializable
    data object GenerarReporte : RouteUserTab()

    @Serializable
    data object Perfil : RouteUserTab()

    //--------------

    @Serializable
    data object EditReport : RouteUserTab()

    @Serializable
    data object InformationAllReport : RouteUserTab()

    @Serializable
    data object ReportRelevant : RouteUserTab()

    @Serializable
    data object ReportSolved : RouteUserTab()

//    @Serializable
//    data object UserCreateReport : RouteUserTab()

    @Serializable
    data object UserReport : RouteUserTab()

    @Serializable
    data object UserWatchAllReport : RouteUserTab()

//    @Serializable
//    data object WatchAccount : RouteUserTab()

    @Serializable
    data class InformationReport(val reporteId: String) : RouteUserTab()


}