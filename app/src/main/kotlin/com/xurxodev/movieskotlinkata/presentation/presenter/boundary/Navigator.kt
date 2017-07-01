package com.xurxodev.movieskotlinkata.presentation.presenter.boundary

import com.xurxodev.movieskotlinkata.domain.entity.Movie

interface Navigator {
    fun openMovieDetail(movie: Movie)
}
