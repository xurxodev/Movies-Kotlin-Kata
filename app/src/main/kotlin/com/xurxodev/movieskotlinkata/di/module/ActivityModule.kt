package com.xurxodev.movieskotlinkata.di.module

import android.app.Activity
import android.content.Context
import com.xurxodev.movieskotlinkata.di.scope.ActivityScope
import com.xurxodev.movieskotlinkata.domain.boundary.Executor
import com.xurxodev.movieskotlinkata.presentation.presenter.MoviesDetailPresenter
import com.xurxodev.movieskotlinkata.presentation.presenter.MoviesListPresenter
import com.xurxodev.movieskotlinkata.domain.boundary.MovieRepository
import com.xurxodev.movieskotlinkata.domain.usecase.GetMovieByIdUseCase
import com.xurxodev.movieskotlinkata.domain.usecase.GetMoviesUseCase
import com.xurxodev.movieskotlinkata.presentation.presenter.boundary.Navigator
import com.xurxodev.movieskotlinkata.presentation.SimpleNavigator
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activityContext: Activity) {

    @Provides @ActivityScope
    fun provideActivityContext(): Context {
        return activityContext
    }

    @Provides @ActivityScope
    fun provideNavigator(activityContext: Context): Navigator {
        return SimpleNavigator(activityContext)
    }

    @Provides @ActivityScope
    fun providesGetMoviesUseCase(movieRepository: MovieRepository,
                                 executor: Executor): GetMoviesUseCase
            = GetMoviesUseCase(movieRepository,executor)

    @Provides @ActivityScope
    fun providesGetMovieByIdUseCase(movieRepository: MovieRepository,
                                    executor: Executor): GetMovieByIdUseCase
            = GetMovieByIdUseCase(movieRepository,executor)

    @Provides @ActivityScope
    fun providesMovieListPresenter(getMoviesUseCase: GetMoviesUseCase,
                                   navigator:Navigator): MoviesListPresenter
            = MoviesListPresenter(getMoviesUseCase, navigator)

    @Provides @ActivityScope
    fun providesMoviesDetailPresenter(getMovieByIdUseCase: GetMovieByIdUseCase): MoviesDetailPresenter
            = MoviesDetailPresenter(getMovieByIdUseCase)
}
