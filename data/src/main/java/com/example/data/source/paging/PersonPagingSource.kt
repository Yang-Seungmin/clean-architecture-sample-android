package com.example.data.source.paging

import com.example.data.api.SwapiApi
import com.example.data.mapper.swapi.nextPage
import com.example.data.mapper.swapi.prevPage
import com.example.data.mapper.swapi.toPerson
import com.example.domain.data.person.Person
import javax.inject.Inject

class PersonPagingSource @Inject constructor(
    swapiApi: SwapiApi
) :
    BasePagingSource<Person>(swapiApi, apiFunction = { swapiApi, page ->
        val response = swapiApi.getPeople(page)
        PageInfo(
            values = response.results.map { it.toPerson() },
            prevPage = response.prevPage,
            nextPage = response.nextPage
        )
    }) {
}