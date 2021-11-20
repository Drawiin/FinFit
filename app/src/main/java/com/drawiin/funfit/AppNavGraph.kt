package com.drawiin.funfit

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.drawiin.core.arch.NavigationRoute
import com.drawiin.feature_auth.addAuthNavGraph
import com.drawiin.feature_student.addStudentNavGraph
import com.drawiin.feature_teacher.addTeacherNavGraph
import com.drawiin.feature_training.addTrainingNavGraph

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.Auth.routeName) {
        addAuthNavGraph(navController, AppRoutes.Auth.routeName)
        addStudentNavGraph(navController, AppRoutes.Student.routeName)
        addTeacherNavGraph(navController, AppRoutes.Teacher.routeName)
        addTrainingNavGraph(navController, AppRoutes.Training.routeName)
    }
}

sealed class AppRoutes(override val routeName: String):NavigationRoute {
    object Auth: AppRoutes("auth")
    object Student: AppRoutes("student")
    object Teacher: AppRoutes("teacher")
    object Training: AppRoutes("training")
}
