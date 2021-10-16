package com.example.data.source.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.api.SwapiApi
import com.example.data.entity.film.FilmEntity
import com.example.data.entity.person.PersonEntity
import com.example.data.entity.planet.PlanetEntity
import com.example.data.entity.specie.SpecieEntity
import com.example.data.entity.starship.StarshipEntity
import com.example.data.entity.vehicle.VehicleEntity
import com.example.data.source.SwapiDataSource
import com.example.data.source.paging.*
import com.example.domain.data.film.Film
import com.example.domain.data.person.Person
import com.example.domain.data.planet.Planet
import com.example.domain.data.specie.Specie
import com.example.domain.data.starship.Starship
import com.example.domain.data.vehicle.Vehicle
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SwapiRemoteDataSource @Inject constructor(
    private val swapiApi: SwapiApi
) : SwapiDataSource {
    override suspend fun getFilmEntity(filmId: Int): FilmEntity =
        swapiApi.getFilm(filmId)

    override suspend fun getPersonEntity(personId: Int): PersonEntity =
        swapiApi.getPerson(personId)

    override suspend fun getPlanetEntity(planetId: Int): PlanetEntity =
        swapiApi.getPlanet(planetId)

    override suspend fun getSpecieEntity(specieId: Int): SpecieEntity =
        swapiApi.getSpecie(specieId)

    override suspend fun getStarshipEntity(starshipId: Int): StarshipEntity =
        swapiApi.getStarship(starshipId)

    override suspend fun getVehicleEntity(vehicleId: Int): VehicleEntity =
        swapiApi.getVehicle(vehicleId)

    override fun getFilms(): Flow<PagingData<Film>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { FilmPagingSource(swapiApi) }
        ).flow
    }

    override fun getPeople(): Flow<PagingData<Person>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { PersonPagingSource(swapiApi) }
        ).flow
    }

    override fun getPlanets(): Flow<PagingData<Planet>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { PlanetPagingSource(swapiApi) }
        ).flow
    }

    override fun getSpecies(): Flow<PagingData<Specie>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { SpeciePagingSource(swapiApi) }
        ).flow
    }

    override fun getStarships(): Flow<PagingData<Starship>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { StarshipPagingSource(swapiApi) }
        ).flow
    }

    override fun getVehicles(): Flow<PagingData<Vehicle>> {
        return Pager(
            config = PagingConfig(pageSize = PAGE_SIZE),
            pagingSourceFactory = { VehiclePagingSource(swapiApi) }
        ).flow
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}