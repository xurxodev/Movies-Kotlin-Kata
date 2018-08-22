package com.xurxodev.movieskotlinkata.domain.usecase

import com.xurxodev.movieskotlinkata.domain.boundary.Executor
import com.xurxodev.movieskotlinkata.domain.boundary.MovieRepository
import com.xurxodev.movieskotlinkata.domain.common.functional.Either
import com.xurxodev.movieskotlinkata.domain.entity.Movie
import com.xurxodev.movieskotlinkata.domain.failures.GetMovieFailure

class GetMovieByIdUseCase(private val movieRepository: MovieRepository,
                          private val executor: Executor) : UseCase(executor) {

    private var id: Long = 0

    fun execute(id: Long, onResult: (Either<GetMovieFailure, Movie>) -> Unit) {
        this.id = id

        asyncExecute {
            val movieResult = movieRepository.getById(id)

            uiExecute { onResult(movieResult) }
        }
    }
}