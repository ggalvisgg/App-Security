package com.appsecurity.ui.user.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.appsecurity.ui.user.navigation.RouteUserTab
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun HomeBottomBar(
    navController: NavHostController
){

    var lista = listOf<NavigationBarUser>(

        NavigationBarUser(
            route = RouteUserTab.Notificaciones,
            icon = Icons.Outlined.Notifications,
            title = "Notificaciones",
            iconSelected = Icons.Filled.Notifications
        ),

        NavigationBarUser(
            route = RouteUserTab.Reportes,
            icon = Icons.Outlined.Info,
            title = "Reportes",
            iconSelected = Icons.Filled.Info
        ),

        NavigationBarUser(
            route = RouteUserTab.Home,
            icon = Icons.Outlined.Home,
            title = "Home",
            iconSelected = Icons.Filled.Home
        ),

        NavigationBarUser(
            route = RouteUserTab.GenerarReporte,
            icon = Icons.Outlined.AddCircle,
            title = "Generar \nReporte",
            iconSelected = Icons.Filled.AddCircle
        ),

        NavigationBarUser(
            route = RouteUserTab.Perfil,
            icon = Icons.Outlined.Person,
            title = "Perfil",
            iconSelected = Icons.Filled.Person
        )
    )

    NavigationBar {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        lista.forEach {

            val isSelected = currentDestination?.route == it.route::class.qualifiedName

            NavigationBarItem(
                label = {
                    Text(
                        text = it.title
                    )
                },
                onClick = {
                    navController.navigate(it.route){
                        popUpTo(navController.graph.startDestinationId){
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {

                    if (isSelected){
                        Icon(
                            imageVector = it.iconSelected,
                            contentDescription = "Icono de ${it.title}"
                        )
                    }else{
                        Icon(
                            imageVector = it.icon,
                            contentDescription = "Icono de ${it.title}"
                        )
                    }
                },
                selected = isSelected
            )
        }
    }
}

data class NavigationBarUser(
    val route : RouteUserTab,
    val title : String,
    val icon : ImageVector,
    val iconSelected: ImageVector
){ }