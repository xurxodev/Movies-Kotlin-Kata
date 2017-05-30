package com.xurxodev.movieskotlinkata.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.xurxodev.moviesandroidkotlin.R
import com.xurxodev.movieskotlinkata.data.FakeMovieRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initilizeRecyclerView()
        loadMovies()
    }


    private fun initilizeRecyclerView() {
        this.itemAdapter = ItemAdapter() { item ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.Companion.EXTRA_ID, item.id)
            startActivity(intent)
        }

        recycler.layoutManager = GridLayoutManager(this, 1)
        recycler.adapter = itemAdapter
    }

    private fun loadMovies() {
        val movies = FakeMovieRepository(this).getAll()

        itemAdapter.setMovies (movies)
    }
}