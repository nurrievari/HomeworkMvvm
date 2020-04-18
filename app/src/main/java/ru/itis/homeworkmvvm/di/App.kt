package ru.itis.homeworkmvvm.di

import android.app.Application
import ru.itis.homeworkmvvm.di.component.AppComponent
import ru.itis.homeworkmvvm.di.component.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .application(this)
            .build()

        component.inject(this)
    }
}
