package com.example.domain.usecase.specie

import com.example.domain.repository.SwapiRepository
import javax.inject.Inject

class GetSpecieDetailUseCase @Inject constructor(
    private val swapiRepository: SwapiRepository
) {
    suspend operator fun invoke(specieId: Int) = swapiRepository.getSpecieDetail(specieId)
}