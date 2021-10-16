package com.example.data.entity.vehicle

import java.io.Serializable

data class VehicleResponse(
    val count: String,
    val next: String?,
    val previous: String?,
    val results: List<VehicleEntity>
) : Serializable
