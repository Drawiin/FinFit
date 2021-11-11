package com.drawiin.funfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.funfit.features.exercise.detail.ExerciseDetailScreen
import com.drawiin.funfit.features.main.MainScreen
import com.drawiin.funfit.features.student.StudentDashboardScreen
import com.drawiin.funfit.features.teacher.create_training.CreateTrainingScreen
import com.drawiin.funfit.features.teacher.trainings.MyTrainingsScreen
import com.drawiin.funfit.features.training.detail.TrainingDetailsScreen

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.drawiin.common_ui.theme.FunFitTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.Home.routeName) {
                    composable(Route.Home.routeName) {
                        MainScreen(
                            onGoToStudent = { navController.navigate(Route.Student.routeName) },
                            onGoToTeacher = { navController.navigate(Route.Teacher.routeName) })
                    }
                    composable(Route.Teacher.routeName) {
                        MyTrainingsScreen(onGoToCreateTraining = { navController.navigate(Route.CreateTraining.routeName) }) {
                            navController.navigate(
                                Route.TrainingDetail.routeName
                            )
                        }
                    }
                    composable(Route.Student.routeName) {
                        StudentDashboardScreen(onGoToTrainingDetail = {
                            navController.navigate(
                                Route.TrainingDetail.routeName
                            )
                        })
                    }

                    composable(Route.CreateTraining.routeName) {
                        CreateTrainingScreen()
                    }

                    composable(Route.TrainingDetail.routeName) {
                        TrainingDetailsScreen { navController.navigate(Route.ExerciseDetail.routeName) }
                    }

                    composable(Route.ExerciseDetail.routeName) {
                        ExerciseDetailScreen()
                    }
                }
            }
        }
    }
}

sealed class Route(val routeName: String) {
    object Home : Route("home")
    object Teacher : Route("teacher")

    object CreateTraining: Route("training/create")
    object TrainingDetail: Route("training/detail")

    object ExerciseDetail: Route("exercise/detail")

    object Student : Route("student")
}
