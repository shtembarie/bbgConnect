package com.bbg.bbgconnect.presentation.ui.contact

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bbg.bbgconnect.data.models.Contact
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
import androidx.compose.material3.Text
import com.bbg.bbgconnect.presentation.ui.emptyState.EmptyState

/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun ContactsTab(
    contacts: List<Contact>,
    getDepartmentName: (String) -> String,
    getLocalizedText: (Map<String, String>) -> String
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = getLocalizedText(mapOf("en" to "Contacts", "de" to "Kontakte")),
            color = LightColors.text
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (contacts.isNotEmpty()) {
            contacts.forEach { contact ->
                ContactCard(
                    contact = contact,
                    departmentName = getDepartmentName(contact.departmentId),
                    isFavorite = false,
                    onClick = {}
                )
            }
        } else {
            EmptyState(
                message = getLocalizedText(
                    mapOf(
                        "en" to "No contacts available for this location",
                        "de" to "Keine Kontakte für diesen Standort verfügbar"
                    )
                )
            )
        }
    }
}