package com.drawiin.funfit.utils.extensions

import com.drawiin.funfit.core.arch.Either
import com.drawiin.funfit.core.error.Failure
import com.google.firebase.database.DatabaseReference
import kotlin.coroutines.resume
import kotlinx.coroutines.suspendCancellableCoroutine


suspend fun <T>DatabaseReference.saveValue(
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
