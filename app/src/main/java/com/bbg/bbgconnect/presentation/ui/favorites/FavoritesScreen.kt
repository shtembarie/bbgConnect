package com.bbg.bbgconnect.presentation.ui.favorites

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bbg.bbgconnect.data.mock.contacts
import com.bbg.bbgconnect.data.mock.departments
import com.bbg.bbgconnect.presentation.ui.contact.ContactCard
import com.bbg.bbgconnect.presentation.ui.emptyState.EmptyState
import com.bbg.bbgconnect.presentation.ui.theme.LightColors

/**
 * Created by Enoklit on 21.05.2025.
 */
@Composable
fun FavoritesScreen(navController: NavController) {
    // TODO: Replace with real ViewModel/store logic
    val favorites = remember { listOf("contact1", "contact2") }

    val favoriteContacts = remember(favorites) {
        contacts.filter { favorites.contains(it.id) }
    }

    val getDepartmentName = { departmentId: String ->
        departments.find { it.id == departmentId }?.name ?: ""
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Favorite Contacts",
            color = LightColors.text,
            fontSize = LightColors.headingFontSize
        )

        Text(
            text = "${favoriteContacts.size} ${if (favoriteContacts.size == 1) "contact" else "contacts"}",
            color = LightColors.subtext,
            fontSize = LightColors.subheadingFontSize,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (favoriteContacts.isNotEmpty()) {
            LazyColumn(
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(favoriteContacts) { contact ->
                    ContactCard(
                        contact = contact,
                        departmentName = getDepartmentName(contact.departmentId),
                        isFavorite = true,
                        onClick = {
                            navController.navigate("contact/${contact.id}")
                        }
                    )
                }
            }
        } else {
            EmptyState(
                message = "No favorite contacts yet. Add contacts to your favorites from their detail page."
            )
        }
    }
}