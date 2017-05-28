package com.xurxodev.movieskotlinkata.data

fun getItems(): List<Movie> {
    var movies:MutableList<Movie> = mutableListOf<Movie>()

    val BASE_ADDRESS = "http://image.tmdb.org/t/p/w1300_and_h730_bestv2/"

    movies.add(Movie(1,"Inferno", BASE_ADDRESS + "anmLLbDx9d98NMZRyVUtxwJR6ab.jpg"))
    movies.add(Movie(2,"Jack Reacher: Never Go Back", BASE_ADDRESS + "4ynQYtSEuU5hyipcGkfD6ncwtwz.jpg"))
    movies.add(Movie(3,"Star Trek Beyond","" + BASE_ADDRESS + "doqRJwhRFsHHneYG82bM0hSTqpz.jpg"))
    movies.add(Movie(4,"Doctor Strange", BASE_ADDRESS + "2wgKgQAqso1p1yP6unsq9nl7Xdc.jpg"))
    movies.add(Movie(5,"The Girl on the Train", BASE_ADDRESS + "fpq86AP0YBYUwNgDvUj5kxwycxH.jpg"))
    movies.add(Movie(6,"Deepwater Horizon", BASE_ADDRESS + "zjYdnBHbIOYBqKZxvBUsT5MevUA.jpg"))
    movies.add(Movie(7,"A Monster Calls", BASE_ADDRESS + "xVW8REyVqKwxAtUYY07UGlZH43L.jpg"))

    return movies.toList()
}

data class Movie(val id:Long, val title:String, val url:String)