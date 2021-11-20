package com.drawiin.firebase.service

import com.drawiin.core.arch.Either
import com.drawiin.core.error.Failure
import com.drawiin.firebase.entitie.FirebaseTraining
import com.drawiin.firebase.entitie.FirebaseUser
import com.drawiin.firebase.extensions.saveValue
import com.drawiin.firebase.extensions.subscribe
import com.google.firebase.database.FirebaseDatabase
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@Singleton
@InstallIn(SingletonComponent::class)
class FirebaseDatabaseService @Inject constructor(private val db: FirebaseDatabase) {

    @ExperimentalCoroutinesApi
    fun getTraining(
        uid: String
    ): Flow<Either<Failure, FirebaseTraining>> =
        db.getReference("$TRAINING/$uid")
            .subscribe()

    @ExperimentalCoroutinesApi
    fun getUser(
        uid: String
    ): Flow<Either<Failure, FirebaseUser>> =
        db.getReference("$USER/$uid")
            .subscribe()

    @ExperimentalCoroutinesApi
    suspend fun saveTraining(
        training: FirebaseTraining
    ): Either<Failure, Void?> = db.getReference("$TRAINING/${training.uid}")
        .saveValue(training)

    @ExperimentalCoroutinesApi
    suspend fun saveUser(
        user: FirebaseUser
    ): Either<Failure, Void?> = db.getReference("$USER/${user.uid}")
        .saveValue(user)

    companion object {
        const val TRAINING = "training"
        const val USER = "user"
    }
}
