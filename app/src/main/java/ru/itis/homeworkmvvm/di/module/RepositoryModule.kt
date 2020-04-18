package ru.itis.homeworkmvvm.di.module

import dagger.Binds
import dagger.Module
import ru.itis.homeworkmvvm.data.network.CovidRepository
import ru.itis.homeworkmvvm.data.network.CovidRepositoryImpl
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindCovidRepository(covidRepositoryImpl: CovidRepositoryImpl): CovidRepository
}
