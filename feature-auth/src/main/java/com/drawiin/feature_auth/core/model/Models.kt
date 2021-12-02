package com.drawiin.feature_auth.core.model

import com.drawiin.core.model.UserType

data class SignupForm(
    val name: String,
    val email: String,
    val password: String,
    val userType: UserType
)

data class LoginForm(
    val email: String,
    val password: String
)
