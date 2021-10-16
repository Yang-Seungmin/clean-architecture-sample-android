package com.example.data.entity.starship

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StarshipEntity(
    val name: String,
    val model: String,
    val manufacturer: String,
    @SerializedName("cost_in_credits")
    val costInCredits: String,
    val length: String,
    @SerializedName("max_atmosphering_speed")
    val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    @SerializedName("cargo_capacity")
    val cargoCapacity: String,
    val consumables: String,
    @SerializedName("hyperdrive_rating")
    val hyperdriveRating: String,
    @SerializedName("MGLT")
    val mglt: String,
    @SerializedName("starship_class")
    val starshipClass: String,
    val pilots: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String
) : Serializable