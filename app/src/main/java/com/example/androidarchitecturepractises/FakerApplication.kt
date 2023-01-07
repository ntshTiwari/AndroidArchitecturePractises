package com.example.androidarchitecturepractises

import android.app.Application
import com.example.androidarchitecturepractises.di.ApplicationComponent
import com.example.androidarchitecturepractises.di.DaggerApplicationComponent

class FakerApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}