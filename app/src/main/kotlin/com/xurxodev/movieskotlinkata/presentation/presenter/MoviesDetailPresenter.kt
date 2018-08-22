package com.xurxodev.movieskotlinkata.presentation.presenter

import com.xurxodev.movieskotlinkata.common.exhaustive
import com.xurxodev.movieskotlinkata.domain.common.functional.fold
import com.xurxodev.movieskotlinkata.domain.entity.Movie
import com.xurxodev.movieskotlinkata.domain.failures.GetMovieFailure
import com.xurxodev.movieskotlinkata.domain.usecase.GetMovieByIdUseCase


class MoviesDetailPresenter(private val getMovieByIdUseCase: GetMovieByIdUseCase) {

    var view: View? = null

    fun attachView(view: View, id:Long) {
        this.view = view

        loadMovie(id)
    }

    fun detachView() {
        this.view = null
    }

    private fun loadMovie(id: Long) {
        loadingMovie()

        getMovieByIdUseCase.execute(id,
                onResult = { result ->
                    result.fold({failure -> showError(failure)}, {movie -> showMovie(movie)})
                })
    }

    private fun showError(failure: GetMovieFailure) {
        when(failure){
            is GetMovieFailure.NetworkConnection -> showConnectionError()
            is GetMovieFailure.MovieNotFound -> showMovieNotFoundError()
        }.exhaustive
    }

    private fun loadingMovie() {
        view?.showLoading()
    }

    private fun showMovie(movie: Movie) {
        view?.hideLoading()
        view?.showMovie(movie)
    }

    private fun showMovieNotFoundError() {
        view?.hideLoading()
        view?.showMovieNotFoundError()
    }

    private fun showConnectionError() {
        view?.hideLoading()
        view?.showConnectionError()
    }

    interface View {
        fun showMovie(movie: Movie)
        fun showLoading()
        fun hideLoading()
        fun showMovieNotFoundError()
        fun showConnectionError()
    }
}

