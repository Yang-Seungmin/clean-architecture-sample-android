package com.example.data.api

import com.example.data.constant.*
import com.example.data.entity.film.FilmEntity
import com.example.data.entity.film.FilmsResponse
import com.example.data.entity.person.PeopleResponse
import com.example.data.entity.person.PersonEntity
import com.example.data.entity.planet.PlanetEntity
import com.example.data.entity.planet.PlanetResponse
import com.example.data.entity.specie.SpecieEntity
import com.example.data.entity.specie.SpecieResponse
import com.example.data.entity.starship.StarshipEntity
import com.example.data.entity.starship.StarshipResponse
import com.example.data.entity.vehicle.VehicleEntity
import com.example.data.entity.vehicle.VehicleResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SwapiApi {
    @GET(SWAPI_API_FILMS)
    suspend fun getFilms(@Query("page") page: Int): FilmsResponse

    @GET("$SWAPI_API_FILMS/{id}")
    suspend fun getFilm(@Path("id") id: Int): FilmEntity

    @GET(SWAPI_API_PEOPLE)
    suspend fun getPeople(@Query("page") page: Int): PeopleResponse

    @GET("$SWAPI_API_PEOPLE/{id}")
    suspend fun getPerson(@Path("id") id: Int): PersonEntity

    @GET(SWAPI_API_PLANETS)
    suspend fun getPlanets(@Query("page") page: Int): PlanetResponse

    @GET("$SWAPI_API_PLANETS/{id}")
    suspend fun getPlanet(@Path("id") id: Int): PlanetEntity

    @GET(SWAPI_API_SPECIES)
    suspend fun getSpecies(@Query("page") page: Int): SpecieResponse

    @GET("$SWAPI_API_SPECIES/{id}")
    suspend fun getSpecie(@Path("id") id: Int): SpecieEntity

    @GET(SWAPI_API_STARSHIPS)
    suspend fun getStarships(@Query("page") page: Int): StarshipResponse

    @GET("$SWAPI_API_STARSHIPS/{id}")
    suspend fun getStarship(@Path("id") id: Int): StarshipEntity

    @GET(SWAPI_API_VEHICLES)
    suspend fun getVehicles(@Query("page") page: Int): VehicleResponse

    @GET("$SWAPI_API_VEHICLES/{id}")
    suspend fun getVehicle(@Path("id") id: Int): VehicleEntity
}