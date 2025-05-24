package com.bbg.bbgconnect.presentation.ui.location.helper

import com.bbg.bbgconnect.data.models.LocalizedText

/**
 * Created by Enoklit on 21.05.2025.
 */

fun LocalizedText.toMap(): Map<String, String> {
    return mapOf(
        "de" to de,
        "en" to en
    ) + translations + other
}
