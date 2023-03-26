package com.github.cybercodernaj.models

import kotlinx.serialization.Serializable

@Serializable
data class ActivityResponse(
    val activity: String,
    val accessibility: Double,
    val type: String,
    val participants: Int,
    val price: Double,
    val key: String,
    val link: String
)
