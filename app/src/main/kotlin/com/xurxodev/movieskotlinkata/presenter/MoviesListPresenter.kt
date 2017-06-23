package com.xurxodev.movieskotlinkata.presenter

import com.xurxodev.movieskotlinkata.model.Movie
import com.xurxodev.movieskotlinkata.presenter.boundary.MovieRepository
import com.xurxodev.movieskotlinkata.presenter.boundary.Navigator
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class MoviesListPresenter(private val movieRepository: MovieRepository,
                          private val navigator:Navigator) {

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

    fun  onMovieClicked(movie: Movie) {
        navigator.openMovieDetail(movie)
    }

    private fun loadMovies() {
        loadingMovies()

        launch(UI) {
            val movies = asyncLoadMovies().await()

            showMovies(movies)
        }
    }

    private fun asyncLoadMovies() = async(CommonPool) {
        movieRepository.getAll()
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

    interface View {
        fun showMovies(movies: List<Movie>)
        fun clearMovies()
        fun showLoading()
        fun hideLoading()
        fun showTotalMovies(count: Int)
    }


}

