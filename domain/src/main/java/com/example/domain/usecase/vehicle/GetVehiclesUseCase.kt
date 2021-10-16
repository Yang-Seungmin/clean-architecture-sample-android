package com.example.domain.usecase.vehicle

import androidx.paging.PagingData
import com.example.domain.data.vehicle.Vehicle
import com.example.domain.repository.SwapiRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetVehiclesUseCase @Inject constructor(
    private val swapiRepository: SwapiRepository
) {
    operator fun invoke(): Flow<PagingData<Vehicle>> = swapiRepository.getVehicles()
}