package com.example.domain.usecase.vehicle

import com.example.domain.repository.SwapiRepository
import javax.inject.Inject

class GetVehicleDetailUseCase @Inject constructor(
    private val swapiRepository: SwapiRepository
) {
    suspend operator fun invoke(vehicleId: Int) = swapiRepository.getVehicleDetail(vehicleId)
}