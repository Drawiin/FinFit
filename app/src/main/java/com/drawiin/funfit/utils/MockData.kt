package com.drawiin.funfit.utils

import com.drawiin.core.model.Exercise
import com.drawiin.core.model.Training

val exercises = listOf(
    com.drawiin.core.model.Exercise(
        id = 1,
        title = "Pula Pula",
        description = "loren ipsolon dolor sit ament"
    ),
    com.drawiin.core.model.Exercise(
        id = 2,
        title = "Pula Pula 2",
        description = "loren ipsolon dolor sit ament 2"
    )
)

val trainings = listOf(
    com.drawiin.core.model.Training(
        uid = "isjdhajsd",
        title = "Treinos 1B",
        exercises = exercises
    ),
    com.drawiin.core.model.Training(
        uid = "isjdhajsd",
        title = "Treinos 2A",
        exercises = exercises
    ),
    com.drawiin.core.model.Training(
        uid = "isjdhajsd",
        title = "Treinos 9C",
        exercises = exercises
    )
)
