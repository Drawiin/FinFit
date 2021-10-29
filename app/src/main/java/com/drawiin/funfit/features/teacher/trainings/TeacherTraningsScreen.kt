package com.drawiin.funfit.features.teacher.trainings

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.drawiin.funfit.common_ui.composables.TrainingItem
import com.drawiin.funfit.utils.trainings

@ExperimentalMaterialApi
@Composable
fun MyTrainingsScreen(onGoToCreateTraining: () -> Unit, onGoToTrainingDetail: () -> Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onGoToCreateTraining) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
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
    }
}