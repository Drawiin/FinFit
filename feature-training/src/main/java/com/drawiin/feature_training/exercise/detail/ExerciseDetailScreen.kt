package com.drawiin.feature_training.exercise.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseDetailScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)) {
        Text(text = "Corrida do balão", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "disponibilize um balão para cada criança e peça para que as coloque entre os joelhos, estipule uma linha de chegada, quem chegar primeiro sem derrubar os balões, vende a competição.")
    }
}
