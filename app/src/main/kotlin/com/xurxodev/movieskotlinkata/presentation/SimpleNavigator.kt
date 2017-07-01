package com.xurxodev.movieskotlinkata.presentation

import android.content.Context
import com.xurxodev.movieskotlinkata.domain.entity.Movie
import com.xurxodev.movieskotlinkata.presentation.presenter.boundary.Navigator
import com.xurxodev.movieskotlinkata.presentation.view.MovieDetailActivity

class SimpleNavigator(private val activityContext: Context) : Navigator {

    override fun openMovieDetail(movie: Movie) {

        val intent = MovieDetailActivity.newIntent(activityContext, movie.id)

        activityContext.startActivity(intent)
    }
}
