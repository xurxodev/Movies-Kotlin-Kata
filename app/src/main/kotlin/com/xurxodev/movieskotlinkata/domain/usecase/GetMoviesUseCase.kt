package com.xurxodev.movieskotlinkata.domain.usecase

import com.xurxodev.movieskotlinkata.domain.boundary.Executor
import com.xurxodev.movieskotlinkata.domain.boundary.MovieRepository
import com.xurxodev.movieskotlinkata.domain.entity.Movie

class GetMoviesUseCase(private val movieRepository: MovieRepository,
                       private val executor: Executor): UseCase(executor) {

    private var onMoviesLoaded: (List<Movie>) -> Unit = {}
    private var onConnectionError: () -> Unit = {}

    fun execute(onMoviesLoaded: (List<Movie>) -> Unit, onConnectionError: () -> Unit) {
        this.onMoviesLoaded = onMoviesLoaded
        this.onConnectionError = onConnectionError

        asyncExecute { run() }
    }

    fun run() {
        try {
            val movies = movieRepository.getAll()

            uiExecute {onMoviesLoaded(movies)}
        } catch (ex: Exception) {
            uiExecute {onConnectionError()}
        }
    }
}
