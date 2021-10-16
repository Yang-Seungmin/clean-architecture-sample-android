package com.example.cleanarchitecture.ui.explore.vehicle.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.base.viewmodel.BaseViewModel
import com.example.cleanarchitecture.utils.withLoading
import com.example.domain.data.vehicle.Vehicle
import com.example.domain.usecase.vehicle.GetVehicleUseCase
import com.example.domain.usecase.vehicle.GetVehiclesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(
    val getVehicleUseCase: GetVehicleUseCase,
    val getVehiclesUseCase: GetVehiclesUseCase
) : BaseViewModel() {
    private val _vehicle = MutableLiveData<Vehicle?>()
    val vehicle: LiveData<Vehicle?> get() = _vehicle

    val flowVehicle = getVehiclesUseCase()

    fun getVehicle(vehicleId: Int?) {
        withLoading {
            _vehicle.postValue(
                vehicleId?.let { getVehicleUseCase(it) }
            )
        }
    }

}