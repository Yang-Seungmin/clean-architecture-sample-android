package com.example.domain.usecase.planet

import com.example.domain.repository.SwapiRepository
import javax.inject.Inject

class GetPlanetUseCase @Inject constructor(
    private val swapiRepository: SwapiRepository
) {
    suspend operator fun invoke(planetId: Int) = swapiRepository.getPlanet(planetId)
}