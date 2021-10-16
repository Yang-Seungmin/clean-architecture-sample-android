package com.example.data.mapper.swapi

import com.example.data.entity.film.FilmsResponse
import com.example.data.entity.person.PeopleResponse
import com.example.data.entity.planet.PlanetResponse
import com.example.data.entity.specie.SpecieResponse
import com.example.data.entity.starship.StarshipResponse
import com.example.data.entity.vehicle.VehicleResponse

val FilmsResponse.nextPage get() = this.next?.split('=')?.last()?.toInt()
val FilmsResponse.prevPage get() = this.previous?.split('=')?.last()?.toInt()

val PeopleResponse.nextPage get() = this.next?.split('=')?.last()?.toInt()
val PeopleResponse.prevPage get() = this.previous?.split('=')?.last()?.toInt()

val PlanetResponse.nextPage get() = this.next?.split('=')?.last()?.toInt()
val PlanetResponse.prevPage get() = this.previous?.split('=')?.last()?.toInt()

val SpecieResponse.nextPage get() = this.next?.split('=')?.last()?.toInt()
val SpecieResponse.prevPage get() = this.previous?.split('=')?.last()?.toInt()

val StarshipResponse.nextPage get() = this.next?.split('=')?.last()?.toInt()
val StarshipResponse.prevPage get() = this.previous?.split('=')?.last()?.toInt()

val VehicleResponse.nextPage get() = this.next?.split('=')?.last()?.toInt()
val VehicleResponse.prevPage get() = this.previous?.split('=')?.last()?.toInt()
