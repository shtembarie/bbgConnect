package com.bbg.bbgconnect.presentation.ui.contact

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bbg.bbgconnect.data.models.Location
import com.bbg.bbgconnect.presentation.ui.theme.LightColors

import androidx.compose.material3.Text
import com.bbg.bbgconnect.presentation.ui.brochure.BrochureList
import com.bbg.bbgconnect.presentation.ui.sozialMedia.VideoPlayer

/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun MediaTab(
    location: Location,
    getLocalizedText: (Map<String, String>) -> String
) {
    Column(modifier = Modifier.padding(16.dp)) {
        if (location.video != null) {
            Text(
                text = getLocalizedText(mapOf("en" to "Location Video", "de" to "Standortvideo")),
                color = LightColors.text
            )
            Spacer(modifier = Modifier.height(12.dp))
            VideoPlayer(videoUri = location.video)
        }

        Spacer(modifier = Modifier.height(24.dp))
        BrochureList(
            brochures = location.brochures,
            getLocalizedText = getLocalizedText
        )
    }
}