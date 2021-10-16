package com.example.cleanarchitecture.ui.explore.specie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.base.viewmodel.BaseViewModel
import com.example.cleanarchitecture.utils.withLoading
import com.example.domain.data.specie.Specie
import com.example.domain.usecase.specie.GetSpecieUseCase
import com.example.domain.usecase.specie.GetSpeciesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SpecieViewModel @Inject constructor(
    val getSpecieUseCase: GetSpecieUseCase,
    val getSpeciesUseCase: GetSpeciesUseCase
) : BaseViewModel() {
    private val _specie = MutableLiveData<Specie?>()
    val specie: LiveData<Specie?> get() = _specie

    val flowSpecie = getSpeciesUseCase()

    fun getSpecie(specieId: Int?) {
        withLoading {
            _specie.postValue(
                specieId?.let { getSpecieUseCase(it) }
            )
        }
    }

}