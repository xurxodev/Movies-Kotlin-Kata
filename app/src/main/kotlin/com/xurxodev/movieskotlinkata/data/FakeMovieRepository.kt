package com.xurxodev.movieskotlinkata.data

import android.content.Context
import com.xurxodev.movieskotlinkata.model.MovieNotFoundException
import com.xurxodev.movieskotlinkata.model.Movie

class FakeMovieRepository (context: Context){

    fun getAll (): List<Movie>{

        val BASE_ADDRESS = "http://image.tmdb.org/t/p/w1300_and_h730_bestv2/"

        var movies:MutableList<Movie> = mutableListOf<Movie>()

        movies.add(Movie(1,"Inferno", BASE_ADDRESS + "anmLLbDx9d98NMZRyVUtxwJR6ab.jpg"))
        movies.add(Movie(2,"Jack Reacher: Never Go Back", BASE_ADDRESS + "4ynQYtSEuU5hyipcGkfD6ncwtwz.jpg"))
        movies.add(Movie(3,"Star Trek Beyond","" + BASE_ADDRESS + "doqRJwhRFsHHneYG82bM0hSTqpz.jpg"))
        movies.add(Movie(4,"Doctor Strange", BASE_ADDRESS + "2wgKgQAqso1p1yP6unsq9nl7Xdc.jpg"))
        movies.add(Movie(5,"The Girl on the Train", BASE_ADDRESS + "fpq86AP0YBYUwNgDvUj5kxwycxH.jpg"))
        movies.add(Movie(6,"Deepwater Horizon", BASE_ADDRESS + "zjYdnBHbIOYBqKZxvBUsT5MevUA.jpg"))
        movies.add(Movie(7,"A Monster Calls", BASE_ADDRESS + "xVW8REyVqKwxAtUYY07UGlZH43L.jpg"))

        simulateDelay();

        return movies.toList()
    }

    private fun simulateDelay() {
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    fun getById (id: Long): Movie{

        val movie = getAll().firstOrNull{it.id == id} ?: throw MovieNotFoundException()

        return movie
    }
}


