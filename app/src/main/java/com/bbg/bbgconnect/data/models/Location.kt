package com.bbg.bbgconnect.data.models

/**
 * Created by Enoklit on 19.05.2025.
 */
data class Location(
    val id: String,
    val name: LocalizedText,
    val address: String,
    val city: LocalizedText,
    val country: LocalizedText,
    val image: String,
    val history: LocalizedText,
    val employeeCount: Int,
    val website: String,
    val brochures: List<Brochure>,
    val social: SocialMedia,
    val video: String? = null,
    val coordinates: Coordinates
)
