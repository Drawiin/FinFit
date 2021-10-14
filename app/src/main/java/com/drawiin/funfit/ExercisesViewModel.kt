package com.drawiin.funfit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drawiin.funfit.core.Constants
import com.drawiin.funfit.core.arch.onError
import com.drawiin.funfit.core.arch.onSuccess
import com.drawiin.funfit.utils.UUIDGenerator
import com.drawiin.funfit.utils.extensions.saveValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ExercisesViewModel : ViewModel() {
    private val database = Firebase.database
    private val dbRef = database.reference
    val state = MutableStateFlow<ExerciseState>(ExerciseState.Empty)

    fun addExercise(trainingSet: List<String>) {
        val trainingSetId = UUIDGenerator.generateUUID()

        viewModelScope.launch {
            dbRef.child(Constants.Database.trainingPath)
                .child(trainingSetId)
                .saveValue(trainingSet)
                .onSuccess {
                    state.compareAndSet(
                        expect = ExerciseState.Empty,
                        update = ExerciseState.Created(uuid = trainingSetId)
                    )
                }
                .onError { /* TODO: 13/10/2021 */  }
        }
    }
}

sealed class ExerciseState {
    object Empty : ExerciseState()
    data class Created(val uuid: String) : ExerciseState()
}