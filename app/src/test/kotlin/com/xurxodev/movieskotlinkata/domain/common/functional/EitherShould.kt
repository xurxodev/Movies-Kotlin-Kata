package com.xurxodev.movieskotlinkata.domain.common.functional

import com.xurxodev.movieskotlinkata.domain.common.failures.Failure
import com.xurxodev.movieskotlinkata.domain.entity.Movie
import org.amshove.kluent.`should contain`
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldBeInstanceOf

import org.junit.Test
import kotlin.test.fail


class EitherShould {

    @Test
    fun success_either_should_return_right_type() {

        val movie = givenAMovie()
        val movieSuccessResult = Either.Right(movie)

        movieSuccessResult shouldBeInstanceOf Either::class.java
        movieSuccessResult.isRight shouldBe true
        movieSuccessResult.isLeft shouldBe false
        movieSuccessResult.fold({ fail() },
                { right ->
                    right shouldBeInstanceOf Movie::class.java
                    right shouldBe movie
                })

    }

    @Test
    fun fail_either_should_return_left_type() {

        val failure = Failure.NetworkConnection();
        val movieFailResult = Either.Left(failure)

        movieFailResult shouldBeInstanceOf Either::class.java
        movieFailResult.isRight shouldBe false
        movieFailResult.isLeft shouldBe true
        movieFailResult.fold({ left ->
            left shouldBeInstanceOf Failure::class.java
            left shouldBe failure
        }, { fail() })

    }

    @Test
    fun mapped_success_either_should_return_mapped_right_type() {

        val movie = givenAMovie()
        val movieSuccessResult = Either.Right(movie)

        val mappedResult = movieSuccessResult.map { mapMovie(it) }

        mappedResult.fold({ fail() },
                { right ->
                    right.title `should contain` " mapped"
                })

    }

    @Test
    fun mapped_fail_either_should_return_return_left_type() {

        val failure = Failure.NetworkConnection();
        val movieFailResult = Either.Left(failure)

        val resultMapped = movieFailResult.map { mapMovie(it) }

        resultMapped.fold({ left -> left shouldBe failure }, { fail() })
    }

    fun mapMovie(it: Movie) =
            Movie(it.id, it.title + " mapped", it.url, it.overview)

    @Test
    fun mapped_success_either_list_should_return_mapped_list_right_type() {

        val movieList = listOf(givenAMovie("Ironman"), givenAMovie("Batman"))
        val movieListSuccessResult = Either.Right(movieList)

        val resultMapped = movieListSuccessResult.map { it.map { mapMovie(it) } }

        resultMapped.fold({ fail() },
                { right ->
                    for (movie in right)
                        movie.title `should contain` " mapped"
                })

    }


    @Test
    fun mapped_fail_either_list_should_return_return_left_type() {

        val failure = Failure.NetworkConnection();
        val movieFailResult = Either.Left(failure)

        val resultMapped = movieFailResult.map { mapMovie(it) }

        resultMapped.fold({ left -> left shouldBe failure }, { fail() })

    }

    @Test
    fun flatmap_success_either_lists_should_return_mapped_list_right_type() {

        val movie = givenAMovie("Ironman")
        val movieListSuccessResult = Either.Right(movie)


        val numActorsResult1 = movieListSuccessResult
                .flatMap { returnedMovie ->
                    getInterperpretersInMovie(returnedMovie.id)
                            .map { actors -> actors.size }
                }

        val numActorsResult2 = movieListSuccessResult
                .flatMap { returnedMovie -> getInterperpretersInMovie(returnedMovie.id) }
                .map { actors -> actors.size }

        numActorsResult1.fold({ fail() },
                { right -> right shouldBe 5 })

        numActorsResult2.fold({ fail() },
                { right -> right shouldBe 5 })
    }

    private fun getInterperpretersInMovie(returnedMovie: Long): Either<Failure, List<String>> {
        val interpretersList = listOf("actor 1", "actor 2", "actor 3", "actor 4", "actor 5")
        return Either.Right(interpretersList)
    }


    private fun givenAMovie(title: String = "Ironman"): Movie =
            Movie(1, title, "url", "overview")

}