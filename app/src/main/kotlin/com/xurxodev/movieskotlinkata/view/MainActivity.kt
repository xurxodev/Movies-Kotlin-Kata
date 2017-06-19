package com.xurxodev.movieskotlinkata.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.xurxodev.moviesandroidkotlin.R
import com.xurxodev.movieskotlinkata.App
import com.xurxodev.movieskotlinkata.data.FakeMovieRepository
import com.xurxodev.movieskotlinkata.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var movieRepository: FakeMovieRepository

    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).moviesComponent.inject(this)

        initializeRecyclerView()
        initializeRefreshButton()
        loadMovies()
    }

    private fun initializeRecyclerView() {
        this.itemAdapter = ItemAdapter() { item ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.Companion.EXTRA_ID, item.id)
            startActivity(intent)
        }

        recycler.adapter = itemAdapter
    }

    private fun initializeRefreshButton() = refresh_button.setOnClickListener { loadMovies() }

    private fun loadMovies() {
        loadingMovies()

        launch(UI) {
            val movies = asyncLoadMovies().await()

            loadedMovies(movies)
        }
    }

    private fun asyncLoadMovies() = async(CommonPool) {
        movieRepository.getAll()
    }

    private fun loadingMovies() {
        itemAdapter.clearMovies();
        pb_loading.visibility = View.VISIBLE
        movies_title_text_view.text =getString(R.string.loading_movies_text);
    }

    private fun loadedMovies(movies: List<Movie>) {
        itemAdapter.setMovies(movies)
        pb_loading.visibility = View.GONE
        refreshTitleWithMoviesCount(movies)
    }

    private fun refreshTitleWithMoviesCount(movies: List<Movie>) {
        val countText = getString(R.string.movies_count_text)

        movies_title_text_view.text = String.format(countText, movies.size)
    }
}