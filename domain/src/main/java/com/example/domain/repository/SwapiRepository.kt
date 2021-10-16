package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.data.film.Film
import com.example.domain.data.film.FilmDetail
import com.example.domain.data.person.Person
import com.example.domain.data.person.PersonDetail
import com.example.domain.data.planet.Planet
import com.example.domain.data.planet.PlanetDetail
import com.example.domain.data.specie.Specie
import com.example.domain.data.specie.SpecieDetail
import com.example.domain.data.starship.Starship
import com.example.domain.data.starship.StarshipDetail
import com.example.domain.data.vehicle.Vehicle
import com.example.domain.data.vehicle.VehicleDetail
import kotlinx.coroutines.flow.Flow

interface SwapiRepository {
    suspend fun getFilm(filmId: Int): Film
    suspend fun getPerson(personId: Int): Person
    suspend fun getPlanet(planetId: Int): Planet
    suspend fun getSpecie(specieId: Int): Specie
    suspend fun getStarship(starshipId: Int): Starship
    suspend fun getVehicle(vehicleId: Int): Vehicle

    suspend fun getFilmDetail(filmId: Int): FilmDetail
    suspend fun getPersonDetail(personId: Int): PersonDetail
    suspend fun getPlanetDetail(planetId: Int): PlanetDetail
    suspend fun getSpecieDetail(specieId: Int): SpecieDetail
    suspend fun getStarshipDetail(starshipId: Int): StarshipDetail
    suspend fun getVehicleDetail(vehicleId: Int): VehicleDetail

    fun getFilms(): Flow<PagingData<Film>>
    fun getPeople(): Flow<PagingData<Person>>
    fun getPlanets(): Flow<PagingData<Planet>>
    fun getSpecies(): Flow<PagingData<Specie>>
    fun getStarships(): Flow<PagingData<Starship>>
    fun getVehicles(): Flow<PagingData<Vehicle>>
}