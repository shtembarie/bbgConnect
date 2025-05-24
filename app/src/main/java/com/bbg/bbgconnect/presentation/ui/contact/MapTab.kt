package com.bbg.bbgconnect.presentation.ui.contact

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bbg.bbgconnect.data.models.Location
import com.bbg.bbgconnect.presentation.ui.location.LocationMap
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun MapTab(
    location: Location,
    getLocalizedText: (Map<String, String>) -> String
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = getLocalizedText(mapOf("en" to "Location Map", "de" to "Standortkarte")),
            color = LightColors.text
        )
        Spacer(modifier = Modifier.height(12.dp))

        LocationMap(
            locations = listOf(location),
            selectedLocationId = location.id,
            getLocalizedText = getLocalizedText,
            onSelectLocation = {}
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${location.address}, ${location.city}, ${location.country}",
            color = LightColors.subtext
        )
    }
}