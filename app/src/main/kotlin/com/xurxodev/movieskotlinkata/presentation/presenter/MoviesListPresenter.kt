package com.xurxodev.movieskotlinkata.presentation.presenter

import com.xurxodev.movieskotlinkata.domain.common.functional.fold
import com.xurxodev.movieskotlinkata.domain.entity.Movie
import com.xurxodev.movieskotlinkata.domain.usecase.GetMoviesUseCase
import com.xurxodev.movieskotlinkata.presentation.presenter.boundary.Navigator

class MoviesListPresenter(private val getMoviesUseCase: GetMoviesUseCase,
                          private val navigator: Navigator) {

    var view: View? = null

    fun attachView(view: View) {
        this.view = view

        loadMovies()
    }

    fun detachView() {
        this.view = null
    }

    fun onRefreshAction() {
        loadMovies()
    }

    fun onMovieClicked(movie: Movie) {
        navigator.openMovieDetail(movie)
    }

    private fun loadMovies() {
        loadingMovies();

        getMoviesUseCase.execute(
                onResult = { result ->
                    result.fold({showError()}, {movies -> showMovies(movies)})
                })
    }

    private fun loadingMovies() {
        view?.showLoading()
        view?.clearMovies()
    }

    private fun showMovies(movies: List<Movie>) {
        view?.hideLoading()
        view?.showMovies(movies)
        view?.showTotalMovies(movies.size)
    }

    private fun showError() {
        view?.hideLoading()
        view?.showConnectionError()
    }

    interface View {
        fun showMovies(movies: List<Movie>)
        fun clearMovies()
        fun showLoading()
        fun hideLoading()
        fun showTotalMovies(count: Int)
        fun showConnectionError()
    }
}

