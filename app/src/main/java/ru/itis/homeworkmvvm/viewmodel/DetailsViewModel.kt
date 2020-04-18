package ru.itis.homeworkmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.itis.homeworkmvvm.data.model.Country
import ru.itis.homeworkmvvm.data.network.CovidRepository
import ru.itis.homeworkmvvm.di.scope.ScreenScope
import javax.inject.Inject

@ScreenScope
class DetailsViewModel @Inject constructor(val covidRepository: CovidRepository) : ViewModel() {

    private val disposables = CompositeDisposable()

    private var _country = MutableLiveData<Country>()
    val country: LiveData<Country> = _country

    fun getCountry(country: String) {
        disposables.add(covidRepository.getConcreteCountry(country)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _country.value = it
            }, {
                it.printStackTrace()
            })
        )
    }

}
