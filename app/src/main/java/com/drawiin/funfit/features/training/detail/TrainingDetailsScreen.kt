package com.drawiin.funfit.features.training.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drawiin.funfit.common_ui.composables.ExerciseItem
import com.drawiin.funfit.utils.exercises

@ExperimentalMaterialApi
@Composable
fun TrainingDetailsScreen(goToExerciseDetail: () -> Unit) {
    Column(Modifier.padding(16.dp)) {
        Text(text = "Treinos 8B", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(contentPadding = PaddingValues(vertical = 16.dp)) {
            items(exercises) { e ->
                ExerciseItem(exercise = e) {
                    goToExerciseDetail()
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}