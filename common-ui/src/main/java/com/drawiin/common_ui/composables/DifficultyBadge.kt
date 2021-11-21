package com.drawiin.common_ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.drawiin.common_ui.theme.Error
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.PrimaryColor
import com.drawiin.common_ui.theme.SurfaceColor
import com.drawiin.common_ui.theme.Warning
import com.drawiin.core.model.ExerciseDifficulty

@Composable
fun DifficultyBadge(difficulty: ExerciseDifficulty) {
    val color = when (difficulty) {
        ExerciseDifficulty.EASY -> PrimaryColor
        ExerciseDifficulty.MEDIUM -> Warning
        ExerciseDifficulty.HARD -> Error
    }
    Box(
        Modifier
            .clip(MaterialTheme.shapes.medium)
            .background(color = color)
            .padding(horizontal = Padding.small)
    ) {
        Text(
            text = difficulty.title,
            style = MaterialTheme.typography.caption.copy(color = SurfaceColor)
        )
    }
}
