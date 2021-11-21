package com.drawiin.common_ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.drawiin.common_ui.theme.Border
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Values
import com.drawiin.core.model.ExerciseDifficulty

@ExperimentalMaterialApi
@Composable
fun ExerciseItem(
    modifier: Modifier = Modifier,
    title: String,
    duration: Int,
    difficulty: ExerciseDifficulty,
    onClick: () -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        onClick = onClick,
        role = Role.Button,
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        border = BorderStroke(Border.small, MaterialTheme.colors.onSurface),
        color = Color.Transparent
    ) {
        Column(
            modifier
                .fillMaxWidth().wrapContentHeight()
                .padding(Padding.small)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
            )
            Spacer(modifier = Modifier.height(Values.x2))
            Text(
                text ="\uD83D\uDD52 ${duration.toString()}min",
                style = MaterialTheme.typography.caption,
            )
            Spacer(modifier = Modifier.height(Values.x2))
            DifficultyBadge(difficulty = difficulty)
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun ExerciseItemPreview() {
    FunFitTheme {
        ExerciseItem(title = "Exercicio", duration = 18, difficulty = ExerciseDifficulty.MEDIUM) {

        }
    }
}
