package ru.itis.homeworkmvvm.di.module

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Binds
import dagger.multibindings.IntoMap
import ru.itis.homeworkmvvm.di.ViewModelKey
import ru.itis.homeworkmvvm.viewmodel.CountriesViewModel

@Module(includes = [ViewModelModule::class])
interface CountriesModule {

    @Binds
    @IntoMap
    @ViewModelKey(CountriesViewModel::class)
    fun bindCountriesViewModel(
        countriesViewModel: CountriesViewModel
    ): ViewModel
}
