package com.drawiin.utils

import com.drawiin.core.model.Exercise
import com.drawiin.core.model.ExerciseDifficulty
import com.drawiin.core.model.Training

val exercises = listOf(
    Exercise(
        uid ="1",
        title = "Pula Pula",
        description = "loren ipsolon dolor sit ament",
        difficulty = ExerciseDifficulty.EASY,
        images = listOf(),
        duration = 10
    ),
    Exercise(
        uid = "2",
        title = "Pula Pula 2",
        description = "loren ipsolon dolor sit ament 2",
        difficulty = ExerciseDifficulty.EASY,
        images = listOf(),
        duration = 10
    )
)

val trainings = listOf(
    Training(
        uid = "isjdhajsd",
        title = "Treinos 1B",
        exercises = exercises
    ),
    Training(
        uid = "isjdhajsd",
        title = "Treinos 2A",
        exercises = exercises
    ),
    Training(
        uid = "isjdhajsd",
        title = "Treinos 9C",
        exercises = exercises
    )
)
