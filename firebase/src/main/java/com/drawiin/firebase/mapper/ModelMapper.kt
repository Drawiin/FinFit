package com.drawiin.firebase.mapper

import com.drawiin.core.model.Exercise
import com.drawiin.core.model.ExerciseDifficulty
import com.drawiin.core.model.Training
import com.drawiin.core.model.User
import com.drawiin.firebase.entitie.FirebaseExercise
import com.drawiin.firebase.entitie.FirebaseTraining
import com.drawiin.firebase.entitie.FirebaseUser
import com.drawiin.firebase.entitie.FirebaseUserType

fun FirebaseExercise.toModel() = Exercise(
    uid = uid,
    description = description,
    title = title,
    duration = duration,
    difficulty = ExerciseDifficulty.valueOf(difficulty),
    images = images
)

fun FirebaseTraining.toModel() = Training(
    uid = uid,
    title = title,
    exercises = exercises.map { it.toModel() }
)

fun FirebaseUser.toModel(): User = when(FirebaseUserType.valueOf(type)) {
    FirebaseUserType.TEACHER -> User.Teacher(
            uid = uid,
            name = name,
            trainings = trainings.map { it.toModel() }
        )

    FirebaseUserType.STUDENT -> User.Student(
        uid = uid,
        name = name,
        trainings = trainings.map { it.toModel() }
    )
}
