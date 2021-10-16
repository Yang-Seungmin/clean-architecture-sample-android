package com.example.domain.usecase.specie

import androidx.paging.PagingData
import com.example.domain.data.specie.Specie
import com.example.domain.repository.SwapiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSpeciesUseCase @Inject constructor(
    private val swapiRepository: SwapiRepository
) {
    operator fun invoke(): Flow<PagingData<Specie>> = swapiRepository.getSpecies()
}