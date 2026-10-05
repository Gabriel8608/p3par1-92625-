package com.example.par1p3.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

object Rutas {
    const val CATALOGO = "catalogo"
    const val VENTAS = "ventas"
}

data class ItemNav(
    val ruta: String,
    val etiqueta: String,
    val icono: @Composable () -> Unit
)

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    val items = listOf(
        ItemNav(Rutas.CATALOGO, "Catálogo") {
            Icon(Icons.Default.MenuBook, contentDescription = null)
        },
        ItemNav(Rutas.VENTAS, "Ventas") {
            Icon(Icons.Default.ShoppingCart, contentDescription = null)
        }
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { item ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == item.ruta } == true,
                        onClick = {
                            navController.navigate(item.ruta) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = item.icono,
                        label = { Text(item.etiqueta) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Rutas.CATALOGO,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Rutas.CATALOGO) { PantallaCatalogo() }
            composable(Rutas.VENTAS) { PantallaVentas() }
        }
    }
}