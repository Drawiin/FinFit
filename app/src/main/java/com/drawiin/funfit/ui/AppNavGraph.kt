package com.drawiin.funfit.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.drawiin.core.arch.NavigationRoute
import com.drawiin.feature_auth.addAuthNavGraph
import com.drawiin.feature_student.addStudentNavGraph
import com.drawiin.feature_teacher.addTeacherNavGraph
import com.drawiin.feature_training.addTrainingNavGraph
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.Auth.routeName) {
        addAuthNavGraph(
            navController,
            AppRoutes.Auth.routeName,
            goToStudentGraph = {
                navController.navigate(AppRoutes.Student.routeName)
            },
            goToTeacherGraph = {
                navController.navigate(AppRoutes.Teacher.routeName)
            }
        )
        addStudentNavGraph(navController, AppRoutes.Student.routeName)
        addTeacherNavGraph(
            navController,
            AppRoutes.Teacher.routeName
        ) {
            navController.navigate(AppRoutes.Training.routeName)
        }
        addTrainingNavGraph(navController, AppRoutes.Training.routeName)
    }
}

sealed class AppRoutes(override val routeName: String):NavigationRoute {
    object Auth: AppRoutes("auth")
    object Student: AppRoutes("student")
    object Teacher: AppRoutes("teacher")
    object Training: AppRoutes("training")
}
