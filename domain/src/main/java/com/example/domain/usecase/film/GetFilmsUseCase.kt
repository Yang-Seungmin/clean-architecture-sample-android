package com.example.domain.usecase.film

import androidx.paging.PagingData
import com.example.domain.data.film.Film
import com.example.domain.repository.SwapiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(
    private val swapiRepository: SwapiRepository
) {
    operator fun invoke(): Flow<PagingData<Film>> = swapiRepository.getFilms()
}