package com.example.domain.data.film

import com.example.domain.data.person.Person
import com.example.domain.data.planet.Planet
import com.example.domain.data.specie.Specie
import com.example.domain.data.starship.Starship
import com.example.domain.data.vehicle.Vehicle

data class FilmDetail(
    val id: Int,
    val title: String,
    val producer: String,
    val releaseDate: String,
    val openingCrawl: String,
    val characters: List<Person>,
    val planets: List<Planet>,
    val starships: List<Starship>,
    val vehicles: List<Vehicle>,
    val species: List<Specie>
)