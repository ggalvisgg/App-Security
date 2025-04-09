package com.appsecurity.ui.moderator.navigation

import com.appsecurity.ui.user.navigation.RouteUserTab
import kotlinx.serialization.Serializable

sealed class RouteModerator(){

    @Serializable
    data object Reportes : RouteModerator()

    @Serializable
    data object Home : RouteModerator()

    @Serializable
    data object Perfil : RouteModerator()

}