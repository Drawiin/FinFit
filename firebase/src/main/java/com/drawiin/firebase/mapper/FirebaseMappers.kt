package com.drawiin.firebase.mapper

import com.drawiin.core.model.Exercise
import com.drawiin.core.model.Training
import com.drawiin.core.model.User
import com.drawiin.firebase.entitie.FirebaseExercise
import com.drawiin.firebase.entitie.FirebaseTraining
import com.drawiin.firebase.entitie.FirebaseUser
import com.drawiin.firebase.entitie.FirebaseUserType

fun Exercise.toFirebase() = FirebaseExercise(
    uid = uid,
    title = title,
    description = description,
    duration = duration,
    images = images,
    difficulty = difficulty.toString()
)

fun Training.toFirebase() = FirebaseTraining(
    uid = uid,
    title = title,
    exercises = exercises.map { it.toFirebase() }
)

fun User.toFirebase() = when (this){
    is User.Student -> FirebaseUser(
        uid = uid,
        name = name,
        trainings = trainings.map { it.toFirebase() },
        type = FirebaseUserType.STUDENT.toString()
    )
    is User.Teacher ->  FirebaseUser(
        uid = uid,
        name = name,
        trainings = trainings.map { it.toFirebase() },
        type = FirebaseUserType.TEACHER.toString()
    )
}
