package dev.archfoundry.marsphotosapp

import android.app.Application
import dev.archfoundry.marsphotosapp.data.AppContainer
import dev.archfoundry.marsphotosapp.data.DefaultAppContainer

class MarsPhotosApplication : Application(){
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}