package com.example.data.entity.specie

import java.io.Serializable

data class SpecieResponse(
    val count: String,
    val next: String?,
    val previous: String?,
    val results: List<SpecieEntity>
) : Serializable
