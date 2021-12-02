package com.drawiin.utils

import com.drawiin.core.model.Exercise
import com.drawiin.core.model.ExerciseDifficulty
import com.drawiin.core.model.Training

val exercises = listOf(
    Exercise(
        uid ="ex01",
        title = "Corrida de balão",
        description = "disponibilize um balão para cada criança e peça para que as coloque entre os joelhos, estipule uma linha de chegada, quem chegar primeiro sem derrubar os balões, vende a competição",
        difficulty = ExerciseDifficulty.HARD,
        images = listOf(),
        duration = 15
    ),
    Exercise(
        uid = "ex02",
        title = "Festa de dança",
        description = "Coloque música alegre e energizante e solte a dança!",
        difficulty = ExerciseDifficulty.EASY,
        images = listOf(),
        duration = 7
    ),
    Exercise(
        uid ="ex03",
        title = "Polichinelos",
        description = "Posicione-se em pé e pule mechendo os praços e as pernas pelo tempo descrito",
        difficulty = ExerciseDifficulty.EASY,
        images = listOf(),
        duration = 2
    )
)

val trainings = listOf(
    Training(
        uid = "trn01",
        title = "Treinos 1B",
        exercises = exercises
    ),
    Training(
        uid = "trn02",
        title = "Treinos 2A",
        exercises = exercises
    ),
    Training(
        uid = "trn03",
        title = "Treinos 9C",
        exercises = exercises
    )
)
