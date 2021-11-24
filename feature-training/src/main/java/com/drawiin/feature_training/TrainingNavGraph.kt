package com.drawiin.feature_training

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.drawiin.core.arch.NavigationRoute
import com.drawiin.feature_training.exercise.detail.ExerciseDetailScreen
import com.drawiin.feature_training.exercise.help.ExerciseHelpScreen
import com.drawiin.feature_training.training.detail.TrainingDetailsScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@ExperimentalMaterialApi
fun NavGraphBuilder.addTrainingNavGraph(navHostController: NavHostController, routeName: String) {
    navigation(route = routeName, startDestination = TrainingRoutes.TrainingDetail.routeName) {
        composable(TrainingRoutes.TrainingDetail.routeName) {
            TrainingDetailsScreen(
                goToExerciseDetail = { uid ->
                    navHostController.navigate(TrainingRoutes.ExerciseDetail.routeName)
                }
            ) {
                navHostController.popBackStack()
            }
        }

        composable(TrainingRoutes.ExerciseDetail.routeName) {
            ExerciseDetailScreen {
                navHostController.navigate(TrainingRoutes.ExerciseHelper.routeName)
            }
        }

        composable(TrainingRoutes.ExerciseHelper.routeName) {
            ExerciseHelpScreen {
                navHostController.popBackStack()
            }
        }
    }
}

sealed class TrainingRoutes(override val routeName: String): NavigationRoute {
    object TrainingDetail : TrainingRoutes("training/detail")
    object ExerciseDetail : TrainingRoutes("exercise/detail")
    object ExerciseHelper : TrainingRoutes("exercise/helper")
}
