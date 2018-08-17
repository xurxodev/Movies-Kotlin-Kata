package com.xurxodev.movieskotlinkata.domain.usecase

import com.xurxodev.movieskotlinkata.domain.boundary.Executor
import com.xurxodev.movieskotlinkata.domain.boundary.MovieRepository
import com.xurxodev.movieskotlinkata.domain.common.failures.Failure
import com.xurxodev.movieskotlinkata.domain.common.functional.Either
import com.xurxodev.movieskotlinkata.domain.entity.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository,
                       private val executor: Executor): UseCase(executor) {

    private var onMoviesLoaded: (List<Movie>) -> Unit = {}
    private var onConnectionError: () -> Unit = {}

    fun execute(onResult: (Either<Failure,List<Movie>>) -> Unit) {
        this.onMoviesLoaded = onMoviesLoaded
        this.onConnectionError = onConnectionError

        asyncExecute {
            val moviesResult = movieRepository.getAll()

            uiExecute {onResult(moviesResult)}
        }
    }
}
