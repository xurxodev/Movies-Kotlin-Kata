package com.xurxodev.movieskotlinkata.view

import android.content.Context
import com.xurxodev.movieskotlinkata.model.Movie
import com.xurxodev.movieskotlinkata.presenter.boundary.Navigator

class SimpleNavigator(private val activityContext: Context) : Navigator {

    override fun openMovieDetail(movie: Movie) {

        val intent = MovieDetailActivity.newIntent(activityContext, movie.id)

        activityContext.startActivity(intent)
    }
}
