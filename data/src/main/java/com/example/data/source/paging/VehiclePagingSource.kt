package com.example.data.source.paging

import com.example.data.api.SwapiApi
import com.example.data.mapper.swapi.nextPage
import com.example.data.mapper.swapi.prevPage
import com.example.data.mapper.swapi.toVehicle
import com.example.domain.data.vehicle.Vehicle
import javax.inject.Inject

class VehiclePagingSource @Inject constructor(
    swapiApi: SwapiApi
) :
    BasePagingSource<Vehicle>(swapiApi, apiFunction = { swapiApi, page ->
        val response = swapiApi.getVehicles(page)
        PageInfo(
            values = response.results.map { it.toVehicle() },
            prevPage = response.prevPage,
            nextPage = response.nextPage
        )
    }) {
}