package com.drawiin.funfit.core.arch

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

sealed class Either<out E, out S> {
    data class Error<out E>(val error: E) : Either<E, Nothing>()

    data class Success<out S>(val success: S) : Either<Nothing, S>()

    val isSuccess get() = this is Success<S>

    val isError get() = this is Error<E>

    fun <E> error(error: E) = Error(error)

    fun <S> success(success: S) = Success(success)

    fun fold(onError: (E) -> Any, onSuccess: (S) -> Any): Any =
        when (this) {
            is Error -> onError(error)
            is Success -> onSuccess(success)
        }
}

fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
    f(this(it))
}

fun <T, E, S> Either<E, S>.flatMap(fn: (S) -> Either<E, T>): Either<E, T> =
    when (this) {
        is Either.Error -> Either.Error(error)
        is Either.Success -> fn(success)
    }

fun <T, E, S> Either<E, S>.map(fn: (S) -> (T)): Either<E, T> = this.flatMap(fn.c(::success))

fun <E, S> Either<E, S>.getOrElse(value: S): S =
    when (this) {
        is Either.Error -> value
        is Either.Success -> success
    }

fun <E, S> Either<E, S>.onError(fn: (error: E) -> Unit): Either<E, S> =
    this.apply { if (this is Either.Error) fn(error) }

fun <E, S> Either<E, S>.onFlowSuccess(fn: (success: S) -> Unit): Either<E, S> =
    this.apply { if (this is Either.Success) fn(success) }

fun <E, S> Flow<Either<E, S>>.onFlowSuccess(fn: (success: S) -> Unit): Flow<Either<E, S>> =
    map { it.onFlowSuccess(fn) }

fun <E, S> Flow<Either<E, S>>.onFlowFailure(fn: (error: E) -> Unit): Flow<Either<E, S>> =
    map { it.onError(fn) }

fun <T ,E, S> Flow<Either<E, S>>.flowMap(fn: (S) -> (T)): Flow<Either<E, T>> = this.map {
    it.map(fn)
}
