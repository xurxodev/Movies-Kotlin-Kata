package com.xurxodev.movieskotlinkata.domain.common.failures

sealed class Failure {
    class NetworkConnection: Failure()
    class ServerFailure: Failure()

    abstract class FeatureFailure: Failure()
}