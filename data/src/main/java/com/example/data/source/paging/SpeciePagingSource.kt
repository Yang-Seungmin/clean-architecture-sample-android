package com.example.data.source.paging

import com.example.data.api.SwapiApi
import com.example.data.mapper.swapi.nextPage
import com.example.data.mapper.swapi.prevPage
import com.example.data.mapper.swapi.toSpecie
import com.example.domain.data.specie.Specie
import javax.inject.Inject

class SpeciePagingSource @Inject constructor(
    swapiApi: SwapiApi
) :
    BasePagingSource<Specie>(swapiApi, apiFunction = { swapiApi, page ->
        val response = swapiApi.getSpecies(page)
        PageInfo(
            values = response.results.map { it.toSpecie() },
            prevPage = response.prevPage,
            nextPage = response.nextPage
        )
    }) {
}