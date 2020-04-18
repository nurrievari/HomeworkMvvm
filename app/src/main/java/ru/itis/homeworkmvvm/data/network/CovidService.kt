package ru.itis.homeworkmvvm.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.itis.homeworkmvvm.data.model.Country

interface CovidService {

    @GET("countries")
    fun getCountries(): Single<List<Country>>

    @GET("countries/{country}")
    fun getConcreteCountry(@Path("country") country: String): Single<Country>
}
