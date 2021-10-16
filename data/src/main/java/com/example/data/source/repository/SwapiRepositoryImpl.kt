package com.example.data.source.repository

import androidx.paging.PagingData
import com.example.data.mapper.swapi.*
import com.example.data.source.remote.SwapiRemoteDataSource
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
import com.example.domain.repository.SwapiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SwapiRepositoryImpl @Inject constructor(
    private val swapiRemoteDataSource: SwapiRemoteDataSource
) : SwapiRepository {

    override suspend fun getFilm(filmId: Int): Film {
        return swapiRemoteDataSource.getFilmEntity(filmId).toFilm()
    }

    override suspend fun getPerson(personId: Int): Person {
        return swapiRemoteDataSource.getPersonEntity(personId).toPerson()
    }

    override suspend fun getPlanet(planetId: Int): Planet {
        return swapiRemoteDataSource.getPlanetEntity(planetId).toPlanet()
    }

    override suspend fun getSpecie(specieId: Int): Specie {
        return swapiRemoteDataSource.getSpecieEntity(specieId).toSpecie()
    }

    override suspend fun getStarship(starshipId: Int): Starship {
        return swapiRemoteDataSource.getStarshipEntity(starshipId).toStarship()
    }

    override suspend fun getVehicle(vehicleId: Int): Vehicle {
        return swapiRemoteDataSource.getVehicleEntity(vehicleId).toVehicle()
    }

    override suspend fun getFilmDetail(filmId: Int): FilmDetail {
        val filmEntity = swapiRemoteDataSource.getFilmEntity(filmId)

        return FilmDetail(
            id = filmEntity.id,
            title = filmEntity.title,
            producer = filmEntity.producer,
            releaseDate = filmEntity.releaseDate,
            openingCrawl = filmEntity.openingCrawl,
            characters = filmEntity.characters.map {
                swapiRemoteDataSource.getPersonEntity(it.getId()).toPerson()
            },
            planets = filmEntity.planets.map {
                swapiRemoteDataSource.getPlanetEntity(it.getId()).toPlanet()
            },
            starships = filmEntity.starships.map {
                swapiRemoteDataSource.getStarshipEntity(it.getId()).toStarship()
            },
            vehicles = filmEntity.vehicles.map {
                swapiRemoteDataSource.getVehicleEntity(it.getId()).toVehicle()
            },
            species = filmEntity.species.map {
                swapiRemoteDataSource.getSpecieEntity(it.getId()).toSpecie()
            }
        )
    }

    override suspend fun getPersonDetail(personId: Int): PersonDetail {
        val personEntity = swapiRemoteDataSource.getPersonEntity(personId)

        return PersonDetail(
            id = personEntity.id,
            name = personEntity.name,
            height = personEntity.height,
            mass = personEntity.mass,
            hairColor = personEntity.hairColor,
            skinColor = personEntity.skinColor,
            birthYear = personEntity.birthYear,
            gender = personEntity.gender,
            homeworld = swapiRemoteDataSource.getPlanetEntity(personEntity.homeworld.getId())
                .toPlanet(),
            films = personEntity.films.map {
                swapiRemoteDataSource.getFilmEntity(it.getId()).toFilm()
            },
            starships = personEntity.starships.map {
                swapiRemoteDataSource.getStarshipEntity(it.getId()).toStarship()
            },
            vehicles = personEntity.vehicles.map {
                swapiRemoteDataSource.getVehicleEntity(it.getId()).toVehicle()
            },
            species = personEntity.species.map {
                swapiRemoteDataSource.getSpecieEntity(it.getId()).toSpecie()
            }
        )
    }

    override suspend fun getPlanetDetail(planetId: Int): PlanetDetail {
        val planetEntity = swapiRemoteDataSource.getPlanetEntity(planetId)

        return PlanetDetail(
            id = planetEntity.id,
            name = planetEntity.name,
            rotationPeriod = planetEntity.rotationPeriod,
            orbitalPeriod = planetEntity.orbitalPeriod,
            diameter = planetEntity.diameter,
            climate = planetEntity.climate,
            gravity = planetEntity.gravity,
            terrain = planetEntity.terrain,
            surfaceWater = planetEntity.surfaceWater,
            population = planetEntity.population,
            residents = planetEntity.residents.map {
                swapiRemoteDataSource.getPersonEntity(it.getId()).toPerson()
            },
            films = planetEntity.films.map {
                swapiRemoteDataSource.getFilmEntity(it.getId()).toFilm()
            }
        )
    }

    override suspend fun getSpecieDetail(specieId: Int): SpecieDetail {
        val specieEntity = swapiRemoteDataSource.getSpecieEntity(specieId)

        return SpecieDetail(
            id = specieEntity.id,
            name = specieEntity.name,
            classification = specieEntity.classification,
            designation = specieEntity.designation,
            averageHeight = specieEntity.averageHeight,
            skinColors = specieEntity.skinColors,
            hairColors = specieEntity.hairColors,
            eyeColors = specieEntity.eyeColors,
            averageLifespan = specieEntity.averageLifespan,
            homeworld = swapiRemoteDataSource.getPlanetEntity(specieEntity.homeworld.getId())
                .toPlanet(),
            language = specieEntity.language,
            people = specieEntity.people.map {
                swapiRemoteDataSource.getPersonEntity(it.getId()).toPerson()
            },
            films = specieEntity.films.map {
                swapiRemoteDataSource.getFilmEntity(it.getId()).toFilm()
            }
        )
    }

    override suspend fun getStarshipDetail(starshipId: Int): StarshipDetail {
        val starshipEntity = swapiRemoteDataSource.getStarshipEntity(starshipId)

        return StarshipDetail(
            id = starshipEntity.id,
            name = starshipEntity.name,
            model = starshipEntity.model,
            manufacturer = starshipEntity.manufacturer,
            costInCredits = starshipEntity.costInCredits,
            length = starshipEntity.length,
            maxAtmospheringSpeed = starshipEntity.maxAtmospheringSpeed,
            crew = starshipEntity.crew,
            passengers = starshipEntity.passengers,
            cargoCapacity = starshipEntity.cargoCapacity,
            consumables = starshipEntity.consumables,
            hyperdriveRating = starshipEntity.hyperdriveRating,
            mglt = starshipEntity.mglt,
            starshipClass = starshipEntity.starshipClass,
            pilots = starshipEntity.pilots.map {
                swapiRemoteDataSource.getPersonEntity(it.getId()).toPerson()
            },
            films = starshipEntity.films.map {
                swapiRemoteDataSource.getFilmEntity(it.getId()).toFilm()
            }
        )
    }

    override suspend fun getVehicleDetail(vehicleId: Int): VehicleDetail {
        val vehicleEntity = swapiRemoteDataSource.getVehicleEntity(vehicleId)

        return VehicleDetail(
            id = vehicleEntity.id,
            name = vehicleEntity.name,
            model = vehicleEntity.model,
            manufacturer = vehicleEntity.manufacturer,
            costInCredits = vehicleEntity.costInCredits,
            length = vehicleEntity.length,
            maxAtmospheringSpeed = vehicleEntity.maxAtmospheringSpeed,
            crew = vehicleEntity.crew,
            passengers = vehicleEntity.passengers,
            cargoCapacity = vehicleEntity.cargoCapacity,
            consumables = vehicleEntity.consumables,
            vehicleClass = vehicleEntity.vehicleClass,
            pilots = vehicleEntity.pilots.map {
                swapiRemoteDataSource.getPersonEntity(it.getId()).toPerson()
            },
            films = vehicleEntity.films.map {
                swapiRemoteDataSource.getFilmEntity(it.getId()).toFilm()
            }
        )
    }

    override fun getFilms(): Flow<PagingData<Film>> {
        return swapiRemoteDataSource.getFilms()
    }

    override fun getPeople(): Flow<PagingData<Person>> {
        return swapiRemoteDataSource.getPeople()
    }

    override fun getPlanets(): Flow<PagingData<Planet>> {
        return swapiRemoteDataSource.getPlanets()
    }

    override fun getSpecies(): Flow<PagingData<Specie>> {
        return swapiRemoteDataSource.getSpecies()
    }

    override fun getStarships(): Flow<PagingData<Starship>> {
        return swapiRemoteDataSource.getStarships()
    }

    override fun getVehicles(): Flow<PagingData<Vehicle>> {
        return swapiRemoteDataSource.getVehicles()
    }
}