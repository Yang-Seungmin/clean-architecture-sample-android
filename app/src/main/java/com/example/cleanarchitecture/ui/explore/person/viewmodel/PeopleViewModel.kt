package com.example.cleanarchitecture.ui.explore.person.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cleanarchitecture.base.viewmodel.BaseViewModel
import com.example.cleanarchitecture.utils.withLoading
import com.example.domain.data.person.Person
import com.example.domain.usecase.person.GetPeopleUseCase
import com.example.domain.usecase.person.GetPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    val getPeopleUseCase: GetPeopleUseCase,
    val getPersonUseCase: GetPersonUseCase
) : BaseViewModel() {
    private val _person = MutableLiveData<Person?>()
    val person: LiveData<Person?> get() = _person

    val flowPeople = getPeopleUseCase()

    fun getPerson(personId: Int?) {
        withLoading {
            _person.postValue(
                personId?.let { getPersonUseCase(it) }
            )
        }
    }

}