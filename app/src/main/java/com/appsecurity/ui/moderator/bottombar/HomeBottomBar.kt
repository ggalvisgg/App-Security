package com.appsecurity.ui.moderator.bottombar

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.appsecurity.ui.moderator.navigation.RouteModerator
import com.appsecurity.ui.user.navigation.RouteUserTab

@Composable
fun HomeBottomBar(
    navController: NavHostController
){

    var lista = listOf<NavigationBarModerator>(

        NavigationBarModerator(
            route = RouteModerator.Reportes,
            icon = Icons.Outlined.Info,
            title = "Reportes",
            iconSelected = Icons.Filled.Info
        ),

        NavigationBarModerator(
            route = RouteModerator.Home,
            icon = Icons.Outlined.Home,
            title = "Home",
            iconSelected = Icons.Filled.Home
        ),

        NavigationBarModerator(
            route = RouteModerator.Perfil,
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

data class NavigationBarModerator(
    val route : RouteModerator,
    val title : String,
    val icon : ImageVector,
    val iconSelected: ImageVector
){ }