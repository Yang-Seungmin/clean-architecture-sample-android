package com.example.domain.data.vehicle

import com.example.domain.data.film.Film
import com.example.domain.data.person.Person

data class VehicleDetail(
    val id: Int,
    val name: String,
    val model: String,
    val manufacturer: String,
    val costInCredits: String,
    val length: String,
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val vehicleClass: String,
    val pilots: List<Person>,
    val films: List<Film>,
)
