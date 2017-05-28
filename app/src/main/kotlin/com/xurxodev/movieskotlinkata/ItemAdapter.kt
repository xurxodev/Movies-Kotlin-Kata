package com.xurxodev.movieskotlinkata

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.xurxodev.moviesandroidkotlin.R
import com.xurxodev.movieskotlinkata.data.Movie
import kotlinx.android.synthetic.main.view_item.view.*

class ItemAdapter(val movies: List<Movie>, val listener: (Movie) -> Unit) :
        RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_item))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder.itemView) {
        val movie: Movie = movies[position]

        item_title.text = movie.title
        item_image.loadUrl(movie.url)
        setOnClickListener { listener(movie) }
    }

    override fun getItemCount() = movies.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}