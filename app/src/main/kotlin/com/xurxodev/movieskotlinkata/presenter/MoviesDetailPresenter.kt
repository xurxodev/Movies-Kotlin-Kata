package com.xurxodev.movieskotlinkata.presenter

import com.xurxodev.movieskotlinkata.model.Movie
import com.xurxodev.movieskotlinkata.presenter.boundary.MovieRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class MoviesDetailPresenter(private val movieRepository: MovieRepository) {

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

        launch(UI) {
            val movie = asyncLoadMovie(id).await()

            showMovie(movie)
        }
    }

    private fun asyncLoadMovie(id: Long) = async(CommonPool) {
        movieRepository.getById(id)
    }

    private fun loadingMovie() {
        view?.showLoading()
    }

    private fun showMovie(movie: Movie) {
        view?.hideLoading()
        view?.showMovie(movie)
    }

    interface View {
        fun showMovie(movie: Movie)
        fun showLoading()
        fun hideLoading()
    }
}

