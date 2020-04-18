package ru.itis.homeworkmvvm.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.itis.homeworkmvvm.di.ViewModelKey
import ru.itis.homeworkmvvm.viewmodel.DetailsViewModel

@Module(includes = [ViewModelModule::class])
interface DetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    fun bindDetailsViewModel(
        viewModel: DetailsViewModel
    ): ViewModel
}
