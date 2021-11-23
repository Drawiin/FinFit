package com.drawiin.feature_training.training.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.drawiin.common_ui.composables.ExerciseItem
import com.drawiin.common_ui.composables.NavigationAppBar
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Values
import com.drawiin.common_ui.utils.rememberContext
import com.drawiin.core.model.Training
import com.drawiin.utils.UUIDGenerator
import com.drawiin.utils.share.shareSimpleText
import com.drawiin.utils.trainings

@ExperimentalMaterialApi
@Composable
fun TrainingDetailsScreen(goToExerciseDetail: (uid: String) -> Unit, onBackClicked: () -> Unit) {
    val context = rememberContext()

    TrainingDetailBody(
        training = trainings[0],
        onExerciseClicked = goToExerciseDetail,
        onBackClicked = onBackClicked,
        onShareClicked = {
            context.shareSimpleText(
                title = "Compartilhar treino",
                text = "Venha se exercitar e se divertir com esse novo treino no FunFit. " +
                        "\nEsse é o código do seu novo treino: ${UUIDGenerator.generateUUID()}"
            )
        }
    )
}

@ExperimentalMaterialApi
@Composable
fun TrainingDetailBody(
    training: Training,
    onExerciseClicked: (String) -> Unit,
    onBackClicked: () -> Unit,
    onShareClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            NavigationAppBar(
                leadingIcon = Icons.Default.ArrowBack,
                onLeadingClicked = onBackClicked,
                trailingIcon = Icons.Default.Share,
                onTrailingClicked = onShareClicked
            )
        }
    ) {
        Column(Modifier.padding(horizontal = Padding.small)) {
            Text(training.title, style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(Values.x8))
            LazyColumn {
                items(training.exercises) { e ->
                    ExerciseItem(
                        title = e.title,
                        duration = e.duration,
                        difficulty = e.difficulty,
                        onClick = { onExerciseClicked(e.uid) }
                    )
                    Spacer(modifier = Modifier.height(Values.x2))
                }
            }
        }
    }
}
