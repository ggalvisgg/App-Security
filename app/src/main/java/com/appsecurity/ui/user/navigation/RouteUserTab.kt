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
}