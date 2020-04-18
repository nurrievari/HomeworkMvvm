package ru.itis.homeworkmvvm.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.itis.homeworkmvvm.ui.view.MainActivity
import ru.itis.homeworkmvvm.di.App
import ru.itis.homeworkmvvm.di.module.AppModule
import ru.itis.homeworkmvvm.di.module.NetworkModule
import ru.itis.homeworkmvvm.di.module.RepositoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetworkModule::class,
    RepositoryModule::class
])
interface AppComponent {

    fun plusCountriesComponentBuilder(): CountriesComponent.Factory

    fun plusDetailsComponentBuilder(): DetailsComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
}
