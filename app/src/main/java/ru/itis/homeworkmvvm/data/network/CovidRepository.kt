package ru.itis.homeworkmvvm.data.network

import io.reactivex.Single
import ru.itis.homeworkmvvm.data.model.Country

interface CovidRepository {

    fun getAllCountries(): Single<List<Country>>

    fun getConcreteCountry(country: String): Single<Country>
}
