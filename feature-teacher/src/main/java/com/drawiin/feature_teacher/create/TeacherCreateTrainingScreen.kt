package com.drawiin.feature_teacher.create

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.drawiin.common_ui.composables.CustomTextButton
import com.drawiin.common_ui.composables.ExerciseItem
import com.drawiin.common_ui.composables.InlineTextInput
import com.drawiin.common_ui.composables.NavigationAppBar
import com.drawiin.common_ui.composables.PrimaryButton
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Values
import com.drawiin.core.model.Exercise
import com.drawiin.core.model.Training
import com.drawiin.feature_teacher.R
import com.drawiin.utils.UUIDGenerator

@ExperimentalMaterialApi
@Composable
fun TeacherCreateTrainingScreen(onBackPressed: () -> Unit) {
    val training = remember {
        mutableStateOf(
            Training(
                title = "Titulo",
                uid = UUIDGenerator.generateUUID(),
                exercises = listOf()
            )
        )
    }

    TeacherCreateTrainingBody(
        title = training.value.title,
        onTitleChanged = {
            training.value = training.value.copy(
                title = it
            )
        },
        exercises = training.value.exercises,
        {},
        onBackPressed,
        { onBackPressed() }
    )
}

@ExperimentalMaterialApi
@Composable
private fun TeacherCreateTrainingBody(
    title: String,
    onTitleChanged: (String) -> Unit,
    exercises: List<Exercise>,
    onAddExerciseClicked: () -> Unit,
    onBackPressed: () -> Unit,
    onCreateTrainingClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            NavigationAppBar(
                leadingIcon = Icons.Default.ArrowBack,
                onLeadingClicked = onBackPressed,
                title = stringResource(id = R.string.teacher_new_training)
            )
        },
        bottomBar = {
            ActionButton(onCreateTrainingClicked)
        }
    ) {
        Column(
            Modifier
                .padding(horizontal = Padding.small)
                .padding(it)
        ) {
            Spacer(modifier = Modifier.height(Values.x8))
            InlineTextInput(value = title, onValueChanged = onTitleChanged)
            Spacer(modifier = Modifier.height(Values.x8))
            LazyColumn {
                items(exercises) { e ->
                    ExerciseItem(
                        title = e.title,
                        duration = e.duration,
                        difficulty = e.difficulty,
                        onClick = {}
                    )
                    Spacer(modifier = Modifier.height(Values.x2))
                }
            }
            CustomTextButton(
                label = stringResource(id = R.string.teacher_add_exercise),
                icon = Icons.Default.Add,
                onClick = onAddExerciseClicked,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun ActionButton(onCreateTrainingClicked: () -> Unit) {
    Box(
        Modifier
            .padding(horizontal = Padding.small)
            .padding(bottom = Padding.medium)
    ) {
        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.teacher_create),
            onClick = {}
        )
    }
}

@Composable
fun AddExerciseDialog() {

}
