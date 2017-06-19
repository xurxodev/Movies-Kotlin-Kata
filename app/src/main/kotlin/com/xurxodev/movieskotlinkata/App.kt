package com.xurxodev.movieskotlinkata

import android.app.Application
import com.xurxodev.movieskotlinkata.di.ApplicationModule
import com.xurxodev.movieskotlinkata.di.DaggerMoviesComponent
import com.xurxodev.movieskotlinkata.di.DataModule
import com.xurxodev.movieskotlinkata.di.MoviesComponent

class App:Application(){
    val moviesComponent:MoviesComponent by lazy {
        DaggerMoviesComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .dataModule(DataModule())
                .build();
    }

    override fun onCreate() {
        super.onCreate()
    }


}

