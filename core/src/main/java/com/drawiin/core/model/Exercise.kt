package com.drawiin.core.model

data class Exercise(
    val id: Int,
    val title: String,
    val description: String,
    val images: List<String> = listOf(),
    val difficulty: ExerciseDifficulty = ExerciseDifficulty.EASY,
    val duration: String = "\uD83D\uDD52 1h"
)
