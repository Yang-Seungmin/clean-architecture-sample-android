package com.example.domain.usecase.planet

import androidx.paging.PagingData
import com.example.domain.data.planet.Planet
import com.example.domain.repository.SwapiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlanetsUseCase @Inject constructor(
    private val swapiRepository: SwapiRepository
) {
    operator fun invoke(): Flow<PagingData<Planet>> = swapiRepository.getPlanets()
}