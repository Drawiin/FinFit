package com.drawiin.funfit.common_ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.drawiin.funfit.core.model.Exercise

@ExperimentalMaterialApi
@Composable
fun ExerciseItem(exercise: Exercise, onClick: () -> Unit) {
    Surface(
        shape = MaterialTheme.shapes.large,
        elevation = 8.dp,
        onClick = onClick,
        role = Role.Button,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = exercise.title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(16.dp)
        )
    }
}