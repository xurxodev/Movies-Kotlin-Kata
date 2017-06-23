package com.xurxodev.movieskotlinkata.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class ApplicationModule (private val app: Application) {
    @Provides @Singleton fun providesApplication(): Application = this.app
}