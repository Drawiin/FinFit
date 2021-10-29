package com.drawiin.funfit.features.student

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.drawiin.funfit.common_ui.composables.AddTrainingDialog
import com.drawiin.funfit.common_ui.composables.TrainingItem
import com.drawiin.funfit.features.student.dashboard.StudentDashboardViewModel
import com.drawiin.funfit.utils.trainings

@ExperimentalMaterialApi
@Composable
fun StudentDashboardScreen(studentDashboardViewModel: StudentDashboardViewModel = viewModel(), onGoToTrainingDetail: () -> Unit = {}) {
    val state = studentDashboardViewModel.state.collectAsState().value
    var dialogState by remember {
        mutableStateOf(false)
    }

    val closeDialog = { dialogState = false }
    val openDialog = { dialogState = true }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = openDialog) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        AddTrainingDialog(
            shouldShowDialog = dialogState,
            onCloseRequested = closeDialog,
            onFillCode = { code -> studentDashboardViewModel.loadExercises(code) }
        )
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)) {
            Text(text = "Treinos", style = MaterialTheme.typography.h4)
            Spacer(modifier = Modifier.height(32.dp))
            LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)) {
                items(trainings){ t ->
                    TrainingItem(training = t, onGoToTrainingDetail)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
//        when (state) {
//            is StudentsState.EnterCode -> Column(
//                Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                Text(text = "Sem Exercicios")
//            }
//            is StudentsState.LoadedExercises -> Column(Modifier.fillMaxSize()) {
//                LazyColumn(
//                    contentPadding = PaddingValues(16.dp)
//                ) {
//                    items(state.exercises) { exercise ->
//                        Text(text = "\uD83D\uDC49 $exercise", style = MaterialTheme.typography.h5)
//                        Spacer(modifier = Modifier.height(16.dp))
//                    }
//                }
//            }
//        }

    }
}