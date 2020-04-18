package ru.itis.homeworkmvvm.di.component

import dagger.Subcomponent
import ru.itis.homeworkmvvm.di.module.DetailsModule
import ru.itis.homeworkmvvm.di.scope.ScreenScope
import ru.itis.homeworkmvvm.ui.view.DetailsFragment

@ScreenScope
@Subcomponent(modules = [DetailsModule::class])
interface DetailsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailsComponent
    }

    fun inject(fragment: DetailsFragment)
}
