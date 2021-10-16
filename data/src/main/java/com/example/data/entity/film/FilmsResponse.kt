package com.example.data.entity.film

data class FilmsResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<FilmEntity>
)