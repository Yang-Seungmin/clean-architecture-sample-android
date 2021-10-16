package com.example.data.mapper.swapi

import com.example.data.entity.film.FilmEntity
import com.example.data.entity.person.PersonEntity
import com.example.data.entity.planet.PlanetEntity
import com.example.data.entity.specie.SpecieEntity
import com.example.data.entity.starship.StarshipEntity
import com.example.data.entity.vehicle.VehicleEntity
import com.example.data.util.last
import com.example.domain.data.film.Film
import com.example.domain.data.person.Person
import com.example.domain.data.planet.Planet
import com.example.domain.data.specie.Specie
import com.example.domain.data.starship.Starship
import com.example.domain.data.vehicle.Vehicle

private object SwapiMapper {
    fun toFilm(filmEntity: FilmEntity): Film = Film(
        id = filmEntity.id,
        title = filmEntity.title,
        producer = filmEntity.producer,
        releaseDate = filmEntity.releaseDate
    )

    fun toPerson(personEntity: PersonEntity): Person = Person(
        id = personEntity.id,
        name = personEntity.name
    )

    fun toPlanet(planetEntity: PlanetEntity): Planet = Planet(
        id = planetEntity.id,
        name = planetEntity.name
    )

    fun toSpecie(specieEntity: SpecieEntity): Specie = Specie(
        id = specieEntity.id,
        name = specieEntity.name
    )

    fun toStarship(starshipEntity: StarshipEntity): Starship = Starship(
        id = starshipEntity.id,
        name = starshipEntity.name,
        manufacturer = starshipEntity.manufacturer
    )

    fun toVehicle(vehicleEntity: VehicleEntity): Vehicle = Vehicle(
        id = vehicleEntity.id,
        name = vehicleEntity.name,
        manufacturer = vehicleEntity.manufacturer
    )
}

fun FilmEntity.toFilm() = SwapiMapper.toFilm(this)
fun PersonEntity.toPerson() = SwapiMapper.toPerson(this)
fun PlanetEntity.toPlanet() = SwapiMapper.toPlanet(this)
fun SpecieEntity.toSpecie() = SwapiMapper.toSpecie(this)
fun StarshipEntity.toStarship() = SwapiMapper.toStarship(this)
fun VehicleEntity.toVehicle() = SwapiMapper.toVehicle(this)

val FilmEntity.id get() = url.getId()
val PersonEntity.id get() = url.getId()
val PlanetEntity.id get() = url.getId()
val SpecieEntity.id get() = url.getId()
val StarshipEntity.id get() = url.getId()
val VehicleEntity.id get() = url.getId()

fun String.getId() = split('/').last(2).toInt()

