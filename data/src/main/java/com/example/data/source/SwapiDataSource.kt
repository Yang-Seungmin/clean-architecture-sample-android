package com.example.data.source

import androidx.paging.PagingData
import com.example.data.entity.film.FilmEntity
import com.example.data.entity.person.PersonEntity
import com.example.data.entity.planet.PlanetEntity
import com.example.data.entity.specie.SpecieEntity
import com.example.data.entity.starship.StarshipEntity
import com.example.data.entity.vehicle.VehicleEntity
import com.example.domain.data.film.Film
import com.example.domain.data.person.Person
import com.example.domain.data.planet.Planet
import com.example.domain.data.specie.Specie
import com.example.domain.data.starship.Starship
import com.example.domain.data.vehicle.Vehicle
import kotlinx.coroutines.flow.Flow


interface SwapiDataSource {
    suspend fun getFilmEntity(filmId: Int): FilmEntity
    suspend fun getPersonEntity(personId: Int): PersonEntity
    suspend fun getPlanetEntity(planetId: Int): PlanetEntity
    suspend fun getSpecieEntity(specieId: Int): SpecieEntity
    suspend fun getStarshipEntity(starshipId: Int): StarshipEntity
    suspend fun getVehicleEntity(vehicleId: Int): VehicleEntity

    fun getFilms(): Flow<PagingData<Film>>
    fun getPeople(): Flow<PagingData<Person>>
    fun getPlanets(): Flow<PagingData<Planet>>
    fun getSpecies(): Flow<PagingData<Specie>>
    fun getStarships(): Flow<PagingData<Starship>>
    fun getVehicles(): Flow<PagingData<Vehicle>>
}