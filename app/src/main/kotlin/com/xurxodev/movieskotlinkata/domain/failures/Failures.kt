package com.xurxodev.movieskotlinkata.domain.failures

import com.xurxodev.movieskotlinkata.domain.usecase.GetMovieByIdUseCase

sealed class GetMoviesFailure {
    class NetworkConnection: GetMoviesFailure()
}

sealed class GetMovieFailure{
    class NetworkConnection: GetMovieFailure()
    class MovieNotFound: GetMovieFailure()
}