package com.xurxodev.movieskotlinkata.di.module

import android.app.Application
import com.xurxodev.movieskotlinkata.data.FakeMovieRepository
import com.xurxodev.movieskotlinkata.domain.boundary.Executor
import com.xurxodev.movieskotlinkata.domain.boundary.MovieRepository
import com.xurxodev.movieskotlinkata.presentation.executor.CoroutinesExecutor
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class ApplicationModule (private val app: Application) {
    @Provides @Singleton fun providesApplication(): Application = this.app
    @Provides @Singleton fun providesExecutor(): Executor = CoroutinesExecutor()
}