package ru.itis.homeworkmvvm.data.network

import io.reactivex.Single
import ru.itis.homeworkmvvm.data.model.Country
import javax.inject.Inject

class CovidRepositoryImpl @Inject constructor(private var api: CovidService)
    : CovidRepository {

    override fun getAllCountries(): Single<List<Country>> {
        return api.getCountries()
    }

    override fun getConcreteCountry(country: String): Single<Country> {
        return api.getConcreteCountry(country)
    }
}
