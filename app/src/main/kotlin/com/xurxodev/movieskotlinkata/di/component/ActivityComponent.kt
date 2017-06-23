package com.xurxodev.movieskotlinkata.di.component

import com.xurxodev.movieskotlinkata.di.module.ActivityModule
import com.xurxodev.movieskotlinkata.di.scope.ActivityScope
import com.xurxodev.movieskotlinkata.view.MovieDetailActivity
import com.xurxodev.movieskotlinkata.view.MovieListActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(movieListActivity: MovieListActivity)

    fun inject(movieDetailActivity: MovieDetailActivity)

    @Subcomponent.Builder
    interface Builder {
        fun activityModule(activityModule: ActivityModule): Builder

        fun build(): ActivityComponent
    }
}
