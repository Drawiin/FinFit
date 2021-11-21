package com.drawiin.feature_training

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.drawiin.core.arch.NavigationRoute

fun NavGraphBuilder.addTrainingNavGraph(navHostController: NavHostController, routeName: String) {
    navigation(route = routeName, startDestination = TrainingRoutes.Training.routeName) {
        composable(TrainingRoutes.Training.routeName){

        }

        composable(TrainingRoutes.Exercise.routeName){

        }

        composable(TrainingRoutes.ExerciseHelper.routeName){

        }
    }
}

sealed class TrainingRoutes(override val routeName: String): NavigationRoute {
    object Training: TrainingRoutes("training/detail")
    object Exercise: TrainingRoutes("exercise/detail")
    object ExerciseHelper: TrainingRoutes("exercise/helper")
}
