package com.bbg.bbgconnect.presentation.ui.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.bbg.bbgconnect.presentation.ui.favorites.FavoritesScreen
import com.bbg.bbgconnect.presentation.ui.location.LocationsScreen
import com.bbg.bbgconnect.presentation.ui.theme.LightColors

/**
 * Created by Enoklit on 21.05.2025.
 */
@Composable
fun TabsScreen(navController: NavController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = LightColors.card) {
                val currentDestination = bottomNavController.currentBackStackEntryAsState().value?.destination?.route

                NavigationBarItem(
                    selected = currentDestination == "locations",
                    onClick = { bottomNavController.navigate("locations") },
                    icon = { Icon(Icons.Filled.Place, contentDescription = null) },
                    label = { Text("Locations") } // Replace with localized text
                )
                NavigationBarItem(
                    selected = currentDestination == "favorites",
                    onClick = { bottomNavController.navigate("favorites") },
                    icon = { Icon(Icons.Filled.Star, contentDescription = null) },
                    label = { Text("Favorites") }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = "locations",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("locations") {
                LocationsScreen(navController)
            }
            composable("favorites") {
                FavoritesScreen(navController)
            }
        }
    }
}