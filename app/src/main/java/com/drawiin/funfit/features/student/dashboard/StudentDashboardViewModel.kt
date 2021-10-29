package com.drawiin.funfit.features.student.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drawiin.funfit.core.Constants
import com.drawiin.funfit.core.arch.onFlowFailure
import com.drawiin.funfit.core.arch.onFlowSuccess
import com.drawiin.funfit.utils.extensions.subscribe
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StudentDashboardViewModel : ViewModel() {
    private val database = Firebase.database
    private val dbRef = database.reference
    val state = MutableStateFlow<StudentsState>(StudentsState.EnterCode(""))

    @ExperimentalCoroutinesApi
    fun loadExercises(code: String) {
        viewModelScope.launch{
            dbRef.child(Constants.Database.trainingPath)
                .child(code)
                .subscribe<List<String>>()
                .onFlowSuccess { state.value = StudentsState.LoadedExercises(it) }
                .onFlowFailure { /*TODO*/ }
                .collect { }
        }
    }
}

sealed class StudentsState {
    data class EnterCode(val code: String) : StudentsState()
    data class LoadedExercises(val exercises: List<String>) : StudentsState()
}
