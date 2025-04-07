package com.appsecurity.ui.user.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.appsecurity.ui.user.navigation.RouteUserTab

@Composable
fun HomeBottomBar(
    navController: NavHostController
){
    NavigationBar {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Icono de notificaciones"
                )
            },
            selected = false,
            onClick = {
                navController.navigate(RouteUserTab.Notificaciones)
            },
            label = {
                Text(text = "Notificaciones")
            }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Icono de reportes"
                )
            },
            selected = false,
            onClick = {
                navController.navigate(RouteUserTab.Reportes)
            },
            label = {
                Text(text = "Reportes")
            }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Icono de home"
                )
            },
            selected = false,
            onClick = {
                navController.navigate(RouteUserTab.Home)
            },
            label = {
                Text(text = "Home")
            }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Icono de generar un reporte"
                )
            },
            selected = false,
            onClick = {
                navController.navigate(RouteUserTab.GenerarReporte)
            },
            label = {
                Text(text = "Generar \nReporte")
            }
        )

        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Icono de perfil"
                )
            },
            selected = false,
            onClick = {
                navController.navigate(RouteUserTab.Perfil)
            },
            label = {
                Text(text = "Perfil")
            }
        )
    }
}