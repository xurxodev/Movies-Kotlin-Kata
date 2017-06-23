package com.xurxodev.movieskotlinkata.presenter.boundary

import com.xurxodev.movieskotlinkata.model.Movie

interface Navigator {
    fun openMovieDetail(movie: Movie)
}
