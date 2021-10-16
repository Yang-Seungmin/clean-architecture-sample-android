package com.example.domain.usecase.person

import androidx.paging.PagingData
import com.example.domain.data.person.Person
import com.example.domain.repository.SwapiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPeopleUseCase @Inject constructor(
    private val swapiRepository: SwapiRepository
) {
    operator fun invoke(): Flow<PagingData<Person>> = swapiRepository.getPeople()
}