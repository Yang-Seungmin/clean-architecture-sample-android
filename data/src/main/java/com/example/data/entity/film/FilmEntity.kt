package com.example.data.entity.film

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FilmEntity(
    val characters: List<String>,
    val created: String,
    val director: String,
    val edited: String,
    @SerializedName("episode_id")
    val episodeId: String,
    @SerializedName("opening_crawl")
    val openingCrawl: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val planets: List<String>,
    val producer: String,
    val species: List<String>,
    val starships: List<String>,
    val title: String,
    val url: String,
    val vehicles: List<String>
) : Serializable