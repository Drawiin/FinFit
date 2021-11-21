package com.drawiin.firebase.entitie

data class FirebaseTraining(
    val uid: String = "",
    val title: String = "",
    val exercises: List<FirebaseExercise> = listOf()
)

data class FirebaseExercise(
    val uid: String = "",
    val title: String = "",
    val description:String = "",
    val duration: Int = 0,
    val difficulty: String = "",
    val images: List<String> = listOf(),
)

data class FirebaseUser(
    val uid: String = "",
    val name: String = "",
    val type: String = "",
    val trainings: List<FirebaseTraining> = listOf()
)

enum class FirebaseUserType(){
    STUDENT, TEACHER
}
