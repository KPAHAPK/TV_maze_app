package com.example.movies.helper

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigator = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
    }
}