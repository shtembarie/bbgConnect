package com.bbg.bbgconnect.presentation.ui.location

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.bbg.bbgconnect.data.mock.contacts
import com.bbg.bbgconnect.data.mock.departments
import com.bbg.bbgconnect.data.mock.locations
import com.bbg.bbgconnect.presentation.ui.contact.ContactsTab
import com.bbg.bbgconnect.presentation.ui.contact.MapTab
import com.bbg.bbgconnect.presentation.ui.contact.MediaTab
import com.bbg.bbgconnect.presentation.ui.emptyState.EmptyState
import com.bbg.bbgconnect.presentation.ui.theme.LightColors

/**
 * Created by Enoklit on 21.05.2025.
 */


@Composable
fun LocationDetailScreen(locationId: String, navController: NavController? = null) {
    val location = locations.find { it.id == locationId }
    var activeTab by remember { mutableStateOf("info") }
    val context = LocalContext.current

    val locationContacts = remember(locationId) {
        contacts.filter { it.locationId == locationId }
    }

    val getDepartmentName = { departmentId: String ->
        departments.find { it.id == departmentId }?.name ?: ""
    }

    val openWebsite: () -> Unit = {
        location?.website?.let {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
            context.startActivity(intent)
        }
    }

    if (location == null) {
        EmptyState(message = "Location not found")
        return
    }

    val getLocalizedText: (Map<String, String>) -> String = { textMap ->
        textMap["en"] ?: textMap.values.firstOrNull() ?: "?"
    }

    val tabs = listOf(
        com.bbg.bbgconnect.data.models.Tab(
            "info",
            mapOf("en" to "Information", "de" to "Informationen")
        ),
        com.bbg.bbgconnect.data.models.Tab(
            "contacts",
            mapOf("en" to "Contacts", "de" to "Kontakte")
        ),
        com.bbg.bbgconnect.data.models.Tab("media", mapOf("en" to "Media", "de" to "Medien")),
        com.bbg.bbgconnect.data.models.Tab("map", mapOf("en" to "Map", "de" to "Karte"))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(LightColors.background)
    ) {
        AsyncImage(
            model = location.image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        LocationTabs(
            tabs = tabs,
            activeTab = activeTab,
            getLocalizedText = getLocalizedText,
            onChangeTab = { activeTab = it }
        )

        when (activeTab) {
            "info" -> {
                InfoTab(location, getLocalizedText, openWebsite)
            }

            "contacts" -> {
                ContactsTab(locationContacts, getDepartmentName, getLocalizedText)
            }

            "media" -> {
                MediaTab(location, getLocalizedText)
            }

            "map" -> {
                MapTab(location, getLocalizedText)
            }
        }
    }
}

