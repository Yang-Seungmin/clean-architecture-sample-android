package com.example.domain.data.specie

import com.example.domain.data.film.Film
import com.example.domain.data.person.Person
import com.example.domain.data.planet.Planet

data class SpecieDetail(
    val id: Int,
    val name: String,
    val classification: String,
    val designation: String,
    val averageHeight: String,
    val skinColors: String,
    val hairColors: String,
    val eyeColors: String,
    val averageLifespan: String,
    val homeworld: Planet,
    val language: String,
    val people: List<Person>,
    val films: List<Film>,
)
