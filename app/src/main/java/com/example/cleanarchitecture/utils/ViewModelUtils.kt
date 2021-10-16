package com.example.cleanarchitecture.utils

import androidx.annotation.NonNull
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.base.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

fun BaseViewModel.withLoading(@NonNull block: suspend () -> Unit) {
    viewModelScope.launch {
        setLoading(true)
        block()
        setLoading(false)
    }
}