package com.drawiin.funfit.features.teacher.create_training

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drawiin.common_ui.composables.AddExerciseDialog
import com.drawiin.common_ui.composables.ExerciseItem
import com.drawiin.funfit.utils.exercises

@ExperimentalMaterialApi
@Composable
fun CreateTrainingScreen() {
    var title by remember {
        mutableStateOf("Titulo")
    }

    var showAddExerciseDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { showAddExerciseDialog = true }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        com.drawiin.common_ui.composables.AddExerciseDialog(shouldShowDialog = showAddExerciseDialog,
            onCloseRequested = { showAddExerciseDialog = false }, onFillCode = {})
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            BasicTextField(
                value = title,
                onValueChange = { title = it },
                textStyle = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(32.dp))
            Divider()
            Text(text = "Exercicios:", style = MaterialTheme.typography.h6)
            LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)) {
                items(exercises) { e ->
                    com.drawiin.common_ui.composables.ExerciseItem(exercise = e) {}
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}
