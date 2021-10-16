package com.example.domain.data.planet

import com.example.domain.data.film.Film
import com.example.domain.data.person.Person

data class PlanetDetail(
    val id: Int,
    val name: String,
    val rotationPeriod: String,
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: String,
    val population: String,
    val residents: List<Person>,
    val films: List<Film>
)