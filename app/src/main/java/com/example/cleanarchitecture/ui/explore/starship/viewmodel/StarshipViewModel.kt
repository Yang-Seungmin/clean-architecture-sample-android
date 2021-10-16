package com.example.cleanarchitecture.ui.explore.starship.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.base.viewmodel.BaseViewModel
import com.example.cleanarchitecture.utils.withLoading
import com.example.domain.data.starship.Starship
import com.example.domain.usecase.starship.GetStarshipUseCase
import com.example.domain.usecase.starship.GetStarshipsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StarshipViewModel @Inject constructor(
    val getStarshipUseCase: GetStarshipUseCase,
    val getStarshipsUseCase: GetStarshipsUseCase
) : BaseViewModel() {
    private val _starship = MutableLiveData<Starship?>()
    val starship: LiveData<Starship?> get() = _starship

    val flowStarship = getStarshipsUseCase()

    fun getStarship(starshipId: Int?) {
        withLoading {
            _starship.postValue(
                starshipId?.let { getStarshipUseCase(it) }
            )
        }
    }

}