package com.example.cleanarchitecture.ui.explore.planet.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.base.viewmodel.BaseViewModel
import com.example.cleanarchitecture.utils.withLoading
import com.example.domain.data.planet.Planet
import com.example.domain.usecase.planet.GetPlanetUseCase
import com.example.domain.usecase.planet.GetPlanetsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlanetViewModel @Inject constructor(
    val getPlanetsUseCase: GetPlanetsUseCase,
    val getPlanetUseCase: GetPlanetUseCase
) : BaseViewModel() {
    private val _planet = MutableLiveData<Planet?>()
    val planet: LiveData<Planet?> get() = _planet

    val flowPlanet = getPlanetsUseCase()

    fun getPlanet(planetId: Int?) {
        withLoading {
            _planet.postValue(
                planetId?.let { getPlanetUseCase(it) }
            )
        }
    }

}