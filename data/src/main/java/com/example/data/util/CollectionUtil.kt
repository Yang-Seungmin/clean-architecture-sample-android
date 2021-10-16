package com.example.data.util

fun <T> List<T>.last(n: Int = 1): T = this[this.size - n]