package ru.itis.homeworkmvvm.di.component

import dagger.Subcomponent
import ru.itis.homeworkmvvm.di.module.CountriesModule
import ru.itis.homeworkmvvm.ui.view.MainActivity
import ru.itis.homeworkmvvm.di.scope.ScreenScope
import ru.itis.homeworkmvvm.ui.view.CountriesFragment

@ScreenScope
@Subcomponent(modules = [CountriesModule::class])
interface CountriesComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CountriesComponent
    }

    fun inject(fragment: CountriesFragment)
}

