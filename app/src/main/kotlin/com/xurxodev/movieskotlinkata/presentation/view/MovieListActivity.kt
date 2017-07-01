package com.xurxodev.movieskotlinkata.presentation.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.xurxodev.moviesandroidkotlin.R
import com.xurxodev.movieskotlinkata.App
import com.xurxodev.movieskotlinkata.di.module.ActivityModule
import com.xurxodev.movieskotlinkata.domain.entity.Movie
import com.xurxodev.movieskotlinkata.presentation.adapter.MovieAdapter
import com.xurxodev.movieskotlinkata.presentation.presenter.MoviesListPresenter
import kotlinx.android.synthetic.main.activity_movies.*
import javax.inject.Inject

class MovieListActivity : AppCompatActivity(), MoviesListPresenter.View {
    @Inject lateinit var presenter: MoviesListPresenter

    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        (application as App).appComponent.activityComponent()
                .activityModule(ActivityModule(this)).build().inject(this)

        initializeRecyclerView()
        initializeRefreshButton()
        initializePresenter()
    }

    private fun initializeRecyclerView() {
        this.movieAdapter = MovieAdapter() { item ->
            presenter.onMovieClicked(item)
        }

        recycler.adapter = movieAdapter
    }

    private fun initializeRefreshButton() {
        refresh_button.setOnClickListener { presenter.onRefreshAction() }
    }

    private fun initializePresenter() {
        presenter.attachView(this)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }


    override fun showMovies(movies: List<Movie>) {
        movieAdapter.setMovies(movies)
    }

    override fun clearMovies() {
        movieAdapter.clearMovies()
    }

    override fun showLoading() {
        pb_loading.visibility = View.VISIBLE
        movies_title_text_view.text =getString(R.string.loading_movies_text);
    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE
    }

    override fun showTotalMovies(count: Int) {
        movies_title_text_view.text =  getString(R.string.movies_count_text,count)
    }

    override fun showConnectionError() {
        this.toast(R.string.connection_error_text)
    }
}