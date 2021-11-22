package com.drawiin.firebase.mapper

import com.drawiin.core.model.Exercise
import com.drawiin.core.model.ExerciseDifficulty
import com.drawiin.core.model.Training
import com.drawiin.core.model.User
import com.drawiin.core.model.UserType
import com.drawiin.firebase.entitie.FirebaseExercise
import com.drawiin.firebase.entitie.FirebaseTraining
import com.drawiin.firebase.entitie.FirebaseUser

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

fun FirebaseUser.toModel(): User = User(
    uid = uid,
    name = name,
    trainings = trainings.map { it.toModel() },
    type = UserType.valueOf(type)
)
