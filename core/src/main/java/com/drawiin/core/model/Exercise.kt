package com.drawiin.core.model

data class Exercise(
    val uid: String,
    val title: String,
    val description: String,
    val images: List<String>,
    val difficulty: ExerciseDifficulty,
    val duration: Int
)
