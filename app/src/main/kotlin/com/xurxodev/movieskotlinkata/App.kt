package com.xurxodev.movieskotlinkata

import android.app.Application
import com.xurxodev.movieskotlinkata.di.module.ApplicationModule
import com.xurxodev.movieskotlinkata.di.module.DataModule
import com.xurxodev.movieskotlinkata.di.component.AppComponent
import com.xurxodev.movieskotlinkata.di.component.DaggerAppComponent

class App:Application(){
    val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .dataModule(DataModule())
                .build();
    }

    override fun onCreate() {
        super.onCreate()
    }

}

