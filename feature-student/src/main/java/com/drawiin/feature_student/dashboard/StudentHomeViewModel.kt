package com.drawiin.feature_student.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class StudentDashboardViewModel : ViewModel() {

    val state = MutableStateFlow<StudentsState>(StudentsState.EnterCode(""))

    @ExperimentalCoroutinesApi
    fun loadExercises(code: String) {
        viewModelScope.launch{}
    }
}

sealed class StudentsState {
    data class EnterCode(val code: String) : StudentsState()
    data class LoadedExercises(val exercises: List<String>) : StudentsState()
}
