package com.xurxodev.movieskotlinkata.presenter.boundary

import com.xurxodev.movieskotlinkata.model.Movie

interface MovieRepository {
    fun getAll (): List<Movie>
    fun getById (id: Long): Movie
}