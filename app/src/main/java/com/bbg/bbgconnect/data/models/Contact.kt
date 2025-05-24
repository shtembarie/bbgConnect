package com.bbg.bbgconnect.data.models

/**
 * Created by Enoklit on 19.05.2025.
 */
data class Contact(
    val id: String,
    val name: String,
    val position: String,
    val email: String,
    val phone: String,
    val photo: String,
    val locationId: String,
    val departmentId: String
)
