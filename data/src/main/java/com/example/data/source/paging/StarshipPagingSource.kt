package com.example.data.source.paging

import com.example.data.api.SwapiApi
import com.example.data.mapper.swapi.nextPage
import com.example.data.mapper.swapi.prevPage
import com.example.data.mapper.swapi.toStarship
import com.example.domain.data.starship.Starship
import javax.inject.Inject

class StarshipPagingSource @Inject constructor(
    swapiApi: SwapiApi
) :
    BasePagingSource<Starship>(swapiApi, apiFunction = { swapiApi, page ->
        val response = swapiApi.getStarships(page)
        PageInfo(
            values = response.results.map { it.toStarship() },
            prevPage = response.prevPage,
            nextPage = response.nextPage
        )
    }) {
}