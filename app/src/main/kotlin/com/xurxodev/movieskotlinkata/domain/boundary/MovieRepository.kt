package com.xurxodev.movieskotlinkata.domain.boundary

import com.xurxodev.movieskotlinkata.domain.entity.Movie

interface MovieRepository {
    fun getAll (): List<Movie>
    fun getById (id: Long): Movie
}