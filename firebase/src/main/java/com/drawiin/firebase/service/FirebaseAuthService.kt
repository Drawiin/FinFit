package com.drawiin.firebase.service

import com.drawiin.core.arch.Either
import com.drawiin.core.arch.flatMap
import com.drawiin.core.error.Failure
import com.drawiin.firebase.extensions.suspend
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.ExperimentalCoroutinesApi

@Singleton
@InstallIn(SingletonComponent::class)
class FirebaseAuthService @Inject constructor(private val auth: FirebaseAuth) {

    fun getCurrentUser(): Either<Failure, FirebaseUser> =
        auth.currentUser?.let { user ->
            Either.Success(user)
        } ?: Either.Error(Failure.UnexpectedError(Exception("User not found")))

    @ExperimentalCoroutinesApi
    suspend fun signUp(email: String, password: String): Either<Failure, FirebaseUser> =
        auth.createUserWithEmailAndPassword(email, password)
            .suspend()
            .flatMap { getCurrentUser() }

    @ExperimentalCoroutinesApi
    suspend fun logIn(email: String, password: String): Either<Failure, FirebaseUser> =
        auth.signInWithEmailAndPassword(email, password)
            .suspend()
            .flatMap { getCurrentUser() }

}
