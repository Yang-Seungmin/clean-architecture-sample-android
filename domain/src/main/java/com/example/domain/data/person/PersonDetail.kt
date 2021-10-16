package com.example.domain.data.person

import com.example.domain.data.film.Film
import com.example.domain.data.planet.Planet
import com.example.domain.data.specie.Specie
import com.example.domain.data.starship.Starship
import com.example.domain.data.vehicle.Vehicle

data class PersonDetail(
    val id: Int,
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val birthYear: String,
    val gender: String,
    val homeworld: Planet,
    val films: List<Film>,
    val species: List<Specie>,
    val vehicles: List<Vehicle>,
    val starships: List<Starship>
)