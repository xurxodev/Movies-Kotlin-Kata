package com.xurxodev.movieskotlinkata.domain.common.functional

import com.xurxodev.movieskotlinkata.domain.entity.Movie
import org.amshove.kluent.`should contain`
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test
import kotlin.test.assertTrue
import kotlin.test.fail


class OptionShould {

    @Test
    fun return_expected_some_option_type() {

        val movie = givenAMovie()
        val movieSomeResult = Option.Some(movie)

        movieSomeResult shouldBeInstanceOf Option::class.java
        movieSomeResult.isEmpty shouldBe false
        movieSomeResult.fold({fail()},
                { movie ->
                    movie shouldBeInstanceOf Movie::class.java
                    movie shouldBe movie
                })

    }

    @Test
    fun return_expected_none_type() {

        val movieNoneResult = Option.None

        movieNoneResult shouldBeInstanceOf Option::class.java
        movieNoneResult.isEmpty shouldBe true
        movieNoneResult.fold({ assertTrue(true)}, { fail() })
    }

    @Test
    fun mapped_some_option_should_return_mapped_some_type() {

        val movie = givenAMovie()
        val movieSomeResult = Option.Some(movie)

        val mappedResult = movieSomeResult.map { mapMovie(it) }

        mappedResult.fold({ fail() },
                { right ->
                    right.title `should contain` " mapped"
                })
    }

    @Test
    fun mapped_none_option_should_return_none_type() {
        val movieNoneResult = Option.None

        val resultMapped = movieNoneResult.map { mapMovie(it) }

        resultMapped.fold({ { assertTrue(true)} }, { fail() })
    }


    @Test
    fun mapped_some_option_list_should_return_mapped_some_type_list() {

        val movieList = listOf(givenAMovie("Ironman"), givenAMovie("Batman"))
        val movieListSomeResult = Option.Some(movieList)

        val resultMapped = movieListSomeResult.map { it.map { mapMovie(it) } }

        resultMapped.fold({ fail() },
                { right ->
                    for (movie in right)
                        movie.title `should contain` " mapped"
                })

    }


    @Test
    fun flatmap_option_some_list_should_return_mapped_list_some_type() {

        val movie = givenAMovie("Ironman")
        val movieListSomeResult = Option.Some(movie)

        val numActorsResult1 = movieListSomeResult
                .flatMap { returnedMovie ->
                    getInterperpretersInMovie(returnedMovie.id)
                            .map { actors -> actors.size }
                }

        val numActorsResult2 = movieListSomeResult
                .flatMap { returnedMovie -> getInterperpretersInMovie(returnedMovie.id) }
                .map { actors -> actors.size }

        numActorsResult1.fold({ fail() },
                { right -> right shouldBe 5 })

        numActorsResult2.fold({ fail() },
                { right -> right shouldBe 5 })
    }

    private fun getInterperpretersInMovie(returnedMovie: Long): Option<List<String>> {
        val interpretersList = listOf("actor 1", "actor 2", "actor 3", "actor 4", "actor 5")
        return Option.Some(interpretersList)
    }

    fun mapMovie(it: Movie) =
            Movie(it.id, it.title + " mapped", it.url, it.overview)

    private fun givenAMovie(title: String = "Ironman"): Movie =
            Movie(1, title, "url", "overview")

}