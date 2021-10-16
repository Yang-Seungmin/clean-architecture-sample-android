package com.example.data.module

import com.example.data.source.repository.SwapiRepositoryImpl
import com.example.domain.repository.SwapiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SwapiRepositoryModule {

    @Binds
    abstract fun bindRepositoryModule(
        swapiRepositoryImpl: SwapiRepositoryImpl
    ): SwapiRepository

}