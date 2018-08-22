package com.xurxodev.movieskotlinkata.domain.boundary

import com.xurxodev.movieskotlinkata.domain.common.functional.Either
import com.xurxodev.movieskotlinkata.domain.entity.Movie
import com.xurxodev.movieskotlinkata.domain.failures.GetMovieFailure
import com.xurxodev.movieskotlinkata.domain.failures.GetMoviesFailure

interface MovieRepository {
    fun getAll (): Either<GetMoviesFailure, List<Movie>>
    fun getById (id: Long): Either<GetMovieFailure, Movie>
}