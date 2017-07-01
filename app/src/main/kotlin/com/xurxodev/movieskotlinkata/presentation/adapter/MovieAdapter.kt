package com.xurxodev.movieskotlinkata.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.xurxodev.moviesandroidkotlin.R
import com.xurxodev.movieskotlinkata.domain.entity.Movie
import com.xurxodev.movieskotlinkata.presentation.view.inflate
import com.xurxodev.movieskotlinkata.presentation.view.loadUrl
import kotlinx.android.synthetic.main.activity_movie_detail.view.*

class MovieAdapter(val listener: (Movie) -> Unit) :
        RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var movies: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_movie))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder.itemView) {
        val movie: Movie = movies[position]

        item_title.text = movie.title
        item_image.loadUrl(movie.url)
        setOnClickListener { listener(movie) }
    }

    fun setMovies (movies: List<Movie>){
        this.movies = movies
        this.notifyDataSetChanged()
    }

    fun clearMovies() {
        movies = ArrayList()
        this.notifyDataSetChanged()
    }

    override fun getItemCount() = movies.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}