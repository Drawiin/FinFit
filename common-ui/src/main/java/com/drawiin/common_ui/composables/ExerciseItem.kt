package com.drawiin.common_ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import com.drawiin.common_ui.theme.Border
import com.drawiin.common_ui.theme.Padding
import com.drawiin.core.model.Exercise

@ExperimentalMaterialApi
@Composable
fun ExerciseItem(exercise: com.drawiin.core.model.Exercise, onClick: () -> Unit) {
    Surface(
        shape = MaterialTheme.shapes.small,
        onClick = onClick,
        role = Role.Button,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(Border.small, MaterialTheme.colors.onSurface)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(Padding.medium)
        ) {
            Text(
                text = exercise.title,
                style = MaterialTheme.typography.h5,
            )
            Text(
                text = exercise.duration,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(vertical = Padding.small)
            )
            DifficultyBadge(difficulty = exercise.difficulty)
        }
    }
}
