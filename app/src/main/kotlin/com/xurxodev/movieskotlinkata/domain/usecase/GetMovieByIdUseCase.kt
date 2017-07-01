package com.xurxodev.movieskotlinkata.domain.usecase

import com.xurxodev.movieskotlinkata.domain.boundary.Executor
import com.xurxodev.movieskotlinkata.domain.boundary.MovieRepository
import com.xurxodev.movieskotlinkata.domain.entity.Movie
import com.xurxodev.movieskotlinkata.domain.exception.MovieNotFoundException

class GetMovieByIdUseCase (private val movieRepository: MovieRepository,
                           private val executor: Executor): UseCase(executor) {

    private var id: Long = 0
    private var onMovieLoaded: (Movie) -> Unit = {}
    private var onMovieNotFoundError: () -> Unit = {}
    private var onConnectionError: () -> Unit = {}

    fun execute(id: Long, onMovieLoaded: (Movie) -> Unit, onMovieNotFoundError: () -> Unit,
                onConnectionError: () -> Unit) {
        this.id = id
        this.onMovieLoaded = onMovieLoaded
        this.onMovieNotFoundError = onMovieNotFoundError
        this.onConnectionError = onConnectionError

        asyncExecute { run() }
    }

    fun run() {
        try {
            val movie = movieRepository.getById(id)

            uiExecute {onMovieLoaded(movie)}
        } catch (ex: MovieNotFoundException) {
            uiExecute {onMovieNotFoundError()}
        } catch (ex: Exception) {
            uiExecute {onConnectionError()}
        }
    }
}