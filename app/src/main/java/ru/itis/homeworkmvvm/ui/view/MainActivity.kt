package ru.itis.homeworkmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.itis.homeworkmvvm.R
import ru.itis.homeworkmvvm.di.App

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        App.component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.also {
            it.beginTransaction().apply {
                replace(R.id.container, CountriesFragment())
                addToBackStack(CountriesFragment::class.java.name)
                commit()
            }
        }
    }
}
