package com.example.cleanarchitecture.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()

    val isLoading: LiveData<Boolean> get() = _isLoading

    fun setLoading(isLoading: Boolean) {
        _isLoading.postValue(isLoading)
    }
}