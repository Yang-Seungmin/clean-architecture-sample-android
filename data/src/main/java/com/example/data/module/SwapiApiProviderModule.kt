package com.example.data.module

import com.example.data.api.SwapiApi
import com.example.data.constant.SWAPI_API_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SwapiApiProviderModule {
    private val retrofit = Retrofit.Builder()
        .baseUrl(SWAPI_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun gson() = Gson()

    @Provides
    @Singleton
    fun provideSwapiApi(): SwapiApi {
        return retrofit.create(SwapiApi::class.java)
    }
}