package com.xurxodev.movieskotlinkata.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.xurxodev.moviesandroidkotlin.R
import com.xurxodev.moviesandroidkotlin.R.id.movies_title_text_view
import com.xurxodev.movieskotlinkata.data.FakeMovieRepository
import com.xurxodev.movieskotlinkata.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class MainActivity : AppCompatActivity() {

    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        FakeMovieRepository(this@MainActivity).getAll()
    }

    private fun loadingMovies() {
        itemAdapter.clearMovies();
        movies_title_text_view.text =getString(R.string.loading_movies_text);
    }

    private fun loadedMovies(movies: List<Movie>) {
        itemAdapter.setMovies(movies)
        refreshTitleWithMoviesCount(movies)
    }

    private fun refreshTitleWithMoviesCount(movies: List<Movie>) {
        val countText = getString(R.string.movies_count_text)

        movies_title_text_view.text = String.format(countText, movies.size)
    }
}