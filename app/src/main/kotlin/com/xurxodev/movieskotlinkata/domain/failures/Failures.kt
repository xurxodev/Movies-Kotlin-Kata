package com.xurxodev.movieskotlinkata.domain.failures

sealed class GetMoviesFailure {
    class NetworkConnection: GetMoviesFailure()
}

sealed class GetMovieFailure{
    class NetworkConnection: GetMovieFailure()
    class MovieNotFound: GetMovieFailure()
}