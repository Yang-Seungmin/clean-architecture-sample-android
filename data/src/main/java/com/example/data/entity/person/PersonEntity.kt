package com.example.data.entity.person

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PersonEntity(
    val name: String,
    val height: String,
    val mass: String,
    @SerializedName("hair_color")
    val hairColor: String,
    @SerializedName("skin_color")
    val skinColor: String,
    @SerializedName("birth_year")
    val birthYear: String,
    val gender: String,
    @SerializedName("home_world")
    val homeworld: String,
    val films: List<String>,
    val species: List<String>,
    val vehicles: List<String>,
    val starships: List<String>,
    val created: String,
    val edited: String,
    val url: String
) : Serializable