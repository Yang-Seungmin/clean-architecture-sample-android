package com.example.data.entity.planet

import java.io.Serializable

data class PlanetResponse(
    val count: String,
    val next: String?,
    val previous: String?,
    val results: List<PlanetEntity>
) : Serializable