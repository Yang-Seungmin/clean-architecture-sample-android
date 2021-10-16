package com.example.data.entity.starship

import java.io.Serializable

data class StarshipResponse(
    val count: String,
    val next: String?,
    val previous: String?,
    val results: List<StarshipEntity>
) : Serializable
