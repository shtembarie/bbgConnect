package com.bbg.bbgconnect.presentation.ui.location

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbg.bbgconnect.data.models.Location
import com.bbg.bbgconnect.presentation.ui.location.helper.toMap
import com.bbg.bbgconnect.presentation.ui.sozialMedia.SocialLinks
import com.bbg.bbgconnect.presentation.ui.theme.LightColors

/**
 * Created by Enoklit on 21.05.2025.
 */
@Composable
fun InfoTab(location: Location, getLocalizedText: (Map<String, String>) -> String, onWebsiteClick: () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = getLocalizedText(location.name.toMap()),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = LightColors.text
        )
        Text(
            text = "${location.address}, ${location.city}, ${location.country}",
            fontSize = 16.sp,
            color = LightColors.subtext
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "${location.employeeCount} " + getLocalizedText(mapOf("en" to "Employees", "de" to "Mitarbeiter")),
            fontSize = 16.sp,
            color = LightColors.text
        )

        TextButton(onClick = onWebsiteClick) {
            Text(text = location.website, color = LightColors.primary)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = getLocalizedText(mapOf("en" to "History", "de" to "Geschichte")),
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = LightColors.text
        )
        Text(
            text = getLocalizedText(location.history.toMap()),
            fontSize = 16.sp,
            color = LightColors.text
        )

        Spacer(modifier = Modifier.height(16.dp))
        SocialLinks(social = location.social)
    }
}
