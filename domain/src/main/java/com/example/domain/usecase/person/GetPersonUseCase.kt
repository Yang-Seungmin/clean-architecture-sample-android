package com.example.domain.usecase.person

import com.example.domain.repository.SwapiRepository
import javax.inject.Inject

class GetPersonUseCase @Inject constructor(
    private val swapiRepository: SwapiRepository
) {
    suspend operator fun invoke(personId: Int) = swapiRepository.getPerson(personId)
}