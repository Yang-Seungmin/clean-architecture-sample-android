package com.example.data.entity.person

import java.io.Serializable

data class PeopleResponse(
    val count: String,
    val next: String?,
    val previous: String?,
    val results: List<PersonEntity>
) : Serializable