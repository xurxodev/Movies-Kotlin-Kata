package com.xurxodev.movieskotlinkata.di.component

import com.xurxodev.movieskotlinkata.di.module.ApplicationModule
import com.xurxodev.movieskotlinkata.di.module.DataModule
import com.xurxodev.movieskotlinkata.view.MovieDetailActivity
import com.xurxodev.movieskotlinkata.view.MovieListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class))
interface AppComponent {
    fun activityComponent(): ActivityComponent.Builder
}

