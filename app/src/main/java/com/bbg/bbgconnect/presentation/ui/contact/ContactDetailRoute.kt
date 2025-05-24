package com.bbg.bbgconnect.presentation.ui.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bbg.bbgconnect.data.mock.contacts
import com.bbg.bbgconnect.data.mock.departments
import com.bbg.bbgconnect.data.mock.locations
import com.bbg.bbgconnect.presentation.ui.emptyState.EmptyState
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
/**
 * Created by Enoklit on 21.05.2025.
 */
@Composable
fun ContactDetailRoute(contactId: String) {
    val contact = contacts.find { it.id == contactId }

    if (contact == null) {
        EmptyState(message = "Contact not found")
        return
    }

    val department = departments.find { it.id == contact.departmentId }
    val location = locations.find { it.id == contact.locationId }

    if (department == null || location == null) {
        EmptyState(message = "Contact data is incomplete")
        return
    }

    // Screen content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .background(LightColors.background)
    ) {
        ContactDetailScreen(
            contact = contact,
            department = department,
            location = location,
            isFavorite = false, // Replace with your favorite logic
            onToggleFavorite = {}
        )
    }
}