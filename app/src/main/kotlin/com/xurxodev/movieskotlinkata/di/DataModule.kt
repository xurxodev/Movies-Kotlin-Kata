package com.xurxodev.movieskotlinkata.di

import android.app.Application
import com.xurxodev.movieskotlinkata.data.FakeMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module class DataModule () {
    @Provides @Singleton
    fun providesMovieRepository(app: Application): FakeMovieRepository = FakeMovieRepository(app)
}
