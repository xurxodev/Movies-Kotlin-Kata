package com.xurxodev.movieskotlinkata.data

import android.app.Application
import com.xurxodev.moviesandroidkotlin.R
import com.xurxodev.movieskotlinkata.model.MovieNotFoundException
import com.xurxodev.movieskotlinkata.model.Movie

class FakeMovieRepository (val context: Application) {

    fun getAll (): List<Movie>{

        val baseAddress = context.getString(R.string.base_address)

        var movies:MutableList<Movie> = mutableListOf<Movie>()

        movies.add(Movie(1,"Inferno", baseAddress + "anmLLbDx9d98NMZRyVUtxwJR6ab.jpg","After waking up in a hospital with amnesia, professor Robert Langdon and a doctor must race against time to foil a deadly global plot."))
        movies.add(Movie(2,"Jack Reacher: Never Go Back", baseAddress + "4ynQYtSEuU5hyipcGkfD6ncwtwz.jpg","Jack Reacher must uncover the truth behind a major government conspiracy in order to clear his name. On the run as a fugitive from the law, Reacher uncovers a potential secret from his past that could change his life forever."))
        movies.add(Movie(3,"Star Trek Beyond","" + baseAddress + "doqRJwhRFsHHneYG82bM0hSTqpz.jpg","The USS Enterprise crew explores the furthest reaches of uncharted space, where they encounter a mysterious new enemy who puts them and everything the Federation stands for to the test."))
        movies.add(Movie(4,"Doctor Strange", baseAddress + "2wgKgQAqso1p1yP6unsq9nl7Xdc.jpg","After his career is destroyed, a brilliant but arrogant surgeon gets a new lease on life when a sorcerer takes him under his wing and trains him to defend the world against evil."))
        movies.add(Movie(5,"The Girl on the Train", baseAddress + "fpq86AP0YBYUwNgDvUj5kxwycxH.jpg","Rachel Watson, devastated by her recent divorce, spends her daily commute fantasizing about the seemingly perfect couple who live in a house that her train passes every day, until one morning she sees something shocking happen there and becomes entangled in the mystery that unfolds."))
        movies.add(Movie(6,"Deepwater Horizon", baseAddress + "zjYdnBHbIOYBqKZxvBUsT5MevUA.jpg","A story set on the offshore drilling rig Deepwater Horizon, which exploded during April 2010 and created the worst oil spill in U.S. history."))
        movies.add(Movie(7,"A Monster Calls", baseAddress + "xVW8REyVqKwxAtUYY07UGlZH43L.jpg","A boy attempts to deal with his mother's illness and the bullying of his classmates by escaping to a fantastical world."))

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


