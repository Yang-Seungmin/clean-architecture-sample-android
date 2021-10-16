package com.example.data.source.paging

import com.example.data.api.SwapiApi
import com.example.data.mapper.swapi.nextPage
import com.example.data.mapper.swapi.prevPage
import com.example.data.mapper.swapi.toPlanet
import com.example.domain.data.planet.Planet
import javax.inject.Inject

class PlanetPagingSource @Inject constructor(
    swapiApi: SwapiApi
) :
    BasePagingSource<Planet>(swapiApi, apiFunction = { swapiApi, page ->
        val response = swapiApi.getPlanets(page)
        PageInfo(
            values = response.results.map { it.toPlanet() },
            prevPage = response.prevPage,
            nextPage = response.nextPage
        )
    }) {
}