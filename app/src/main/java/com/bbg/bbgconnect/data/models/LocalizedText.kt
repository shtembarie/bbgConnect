package com.bbg.bbgconnect.data.models

/**
 * Created by Enoklit on 19.05.2025.
 */
data class LocalizedText(
    val de: String,
    val en: String,
    val other: Map<String, String> = emptyMap(),
    val translations: Map<String, String> = emptyMap()
)
