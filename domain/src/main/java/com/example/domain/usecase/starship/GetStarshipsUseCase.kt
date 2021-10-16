package com.example.domain.usecase.starship

import androidx.paging.PagingData
import com.example.domain.data.starship.Starship
import com.example.domain.repository.SwapiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStarshipsUseCase @Inject constructor(
    private val swapiRepository: SwapiRepository
) {
    operator fun invoke(): Flow<PagingData<Starship>> = swapiRepository.getStarships()
}