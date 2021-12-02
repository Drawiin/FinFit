package com.drawiin.core.model


data class User(
    val uid: String,
    val name: String,
    val trainings: List<Training>,
    val type: UserType
)


enum class UserType {
    TEACHER, STUDENT
}
