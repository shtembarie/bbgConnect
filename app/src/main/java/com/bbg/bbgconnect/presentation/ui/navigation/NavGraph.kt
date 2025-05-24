package com.bbg.bbgconnect.presentation.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bbg.bbgconnect.data.mock.contacts
import com.bbg.bbgconnect.data.mock.departments
import com.bbg.bbgconnect.data.mock.locations
import com.bbg.bbgconnect.presentation.ui.contact.ContactDetailScreen
import com.bbg.bbgconnect.presentation.ui.location.LocationDetailScreen
import com.bbg.bbgconnect.presentation.ui.tabs.TabsScreen

/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "tabs") {
        composable("tabs") {
            TabsScreen(navController)
        }
        composable(
            "location/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val locationId = backStackEntry.arguments?.getString("id") ?: ""
            LocationDetailScreen(locationId)
        }
        composable(
            "contact/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val contactId = backStackEntry.arguments?.getString("id") ?: return@composable
            // Lookup
            val contact = contacts.find { it.id == contactId }
            val department = departments.find { it.id == contact?.departmentId }
            val location = locations.find { it.id == contact?.locationId }

            if (contact != null && department != null && location != null) {
                ContactDetailScreen(
                    contact = contact,
                    department = department,
                    location = location,
                    isFavorite = false, // You can hook this up to your favorites logic
                    onToggleFavorite = { /* Handle toggle */ }
                )
            } else {
                // Handle missing data (optional fallback UI)
                Text("Contact not found")
            }
        }
    }
}