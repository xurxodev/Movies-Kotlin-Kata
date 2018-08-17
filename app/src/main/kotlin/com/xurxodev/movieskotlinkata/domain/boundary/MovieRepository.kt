package com.xurxodev.movieskotlinkata.domain.boundary

import com.xurxodev.movieskotlinkata.domain.common.failures.Failure
import com.xurxodev.movieskotlinkata.domain.common.functional.Either
import com.xurxodev.movieskotlinkata.domain.entity.Movie

interface MovieRepository {
    fun getAll (): Either<Failure, List<Movie>>
    fun getById (id: Long): Either<Failure, Movie>
}