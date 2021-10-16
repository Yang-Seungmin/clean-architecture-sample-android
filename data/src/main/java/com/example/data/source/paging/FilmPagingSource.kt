package com.example.data.source.paging

import com.example.data.api.SwapiApi
import com.example.data.mapper.swapi.nextPage
import com.example.data.mapper.swapi.prevPage
import com.example.data.mapper.swapi.toFilm
import com.example.domain.data.film.Film
import javax.inject.Inject

class FilmPagingSource @Inject constructor(
    swapiApi: SwapiApi
) :
    BasePagingSource<Film>(swapiApi, apiFunction = { swapiApi, page ->
        val response = swapiApi.getFilms(page)
        PageInfo(
            values = response.results.map { it.toFilm() },
            prevPage = response.prevPage,
            nextPage = response.nextPage
        )
    }) {
}