package com.example.cleanarchitecture.ui.explore.film.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.base.viewmodel.BaseViewModel
import com.example.cleanarchitecture.utils.withLoading
import com.example.domain.data.film.Film
import com.example.domain.usecase.film.GetFilmUseCase
import com.example.domain.usecase.film.GetFilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    val getFilmsUseCase: GetFilmsUseCase,
    val getFilmUseCase: GetFilmUseCase
) : BaseViewModel() {
    private val _film = MutableLiveData<Film?>()
    val film: LiveData<Film?> get() = _film

    val flowFilms = getFilmsUseCase()

    fun getFilm(filmId: Int?) {
        withLoading {
            _film.postValue(
                filmId?.let { getFilmUseCase(it) }
            )
        }
    }

}