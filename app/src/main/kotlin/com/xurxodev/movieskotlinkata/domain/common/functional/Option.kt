package com.xurxodev.movieskotlinkata.domain.common.functional


sealed class Option<out A> {
    object None : Option<Nothing>()
    data class Some<out A>(val t: A) : Option<A>()

    val isEmpty get() = this is None

    fun <A> some(t: A): Option<A> = Some(t)
    fun none(): Option<A> = None
}

fun <A,B> Option<A>.fold(ifEmpty: () -> B, ifSome: (A) -> B): B =
        when (this) {
            is Option.None -> ifEmpty()
            is Option.Some -> ifSome(t)
        }

fun <A,B> Option<A>.flatMap(f: (A) -> Option<B>): Option<B> =
        fold({ this as Option.None }, f)

fun <A,B> Option<A>.map(f: (A) -> B):Option<B> =
        flatMap { a -> Option.Some(f(a)) }
