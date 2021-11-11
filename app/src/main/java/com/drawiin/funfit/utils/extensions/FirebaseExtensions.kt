package com.drawiin.funfit.utils.extensions

import com.drawiin.core.arch.Either
import com.drawiin.core.error.Failure
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import kotlin.coroutines.resume
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine


suspend inline fun <T>DatabaseReference.saveValue(
    value: T
): Either<Failure, Void?> = suspendCancellableCoroutine { continuation ->
        setValue(value)
            .addOnSuccessListener {
                continuation.resume(Either.Success(it))
            }
            .addOnCanceledListener {
                continuation.resume(
                    Either.Error(
                        Failure.UnexpectedError(Exception("Operation Canceled"))
                    )
                )
            }
            .addOnFailureListener {
                Either.Error(Failure.UnexpectedError(it))
            }
    }

@ExperimentalCoroutinesApi
inline fun <reified T>DatabaseReference.subscribe()= callbackFlow<Either<Failure, T>> {
    val listener = object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            runCatching {
                val value = snapshot.getValue<T>() as T
                trySend(Either.Success(value))
            }.onFailure { throwable ->
                trySend(
                    Either.Error(Failure.UnexpectedError(Exception(throwable.message)))
                )
                close(throwable)
            }

        }

        override fun onCancelled(error: DatabaseError) {
            val exception = Exception(error.message)
            trySend(
                Either.Error(
                    Failure.UnexpectedError(exception)
                )
            )
            close()
        }
    }

    addValueEventListener(listener)

    awaitClose { removeEventListener(listener) }
}
