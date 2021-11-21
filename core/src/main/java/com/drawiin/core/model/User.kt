package com.drawiin.core.model

sealed class User {
    data class Student(
        val uid: String,
        val name: String,
        val trainings: List<Training>
    ) : User()

    data class Teacher(
        val uid: String,
        val name: String,
        val trainings: List<Training>
    ) : User()
}
