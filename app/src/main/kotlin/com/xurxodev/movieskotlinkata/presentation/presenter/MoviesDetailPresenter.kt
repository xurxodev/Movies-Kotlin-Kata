package com.xurxodev.movieskotlinkata.presentation.presenter

import com.xurxodev.movieskotlinkata.domain.entity.Movie
import com.xurxodev.movieskotlinkata.domain.boundary.MovieRepository
import com.xurxodev.movieskotlinkata.domain.usecase.GetMovieByIdUseCase
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

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
                onMovieLoaded = {showMovie(it)},
                onMovieNotFoundError = {showMovieNotFoundError()},
                onConnectionError = {showConnectionError()})
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

