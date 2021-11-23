package com.drawiin.feature_teacher

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.drawiin.core.arch.NavigationRoute
import com.drawiin.feature_teacher.create.TeacherCreateTrainingScreen
import com.drawiin.feature_teacher.home.TeacherHomeScreen

@ExperimentalMaterialApi
fun NavGraphBuilder.addTeacherNavGraph(
    navHostController: NavHostController,
    routeName: String,
    onGoToTrainingDetail: (uid: String) -> Unit
) {
    navigation(route = routeName, startDestination = TeacherRoutes.Home.routeName) {
        composable(TeacherRoutes.Home.routeName) {
            TeacherHomeScreen(
                onGoToCreateTraining = {
                    navHostController.navigate(TeacherRoutes.CreateTraining.routeName)
                },
                onGoToTrainingDetail = {
                    onGoToTrainingDetail(it)
                }
            )
        }
        composable(TeacherRoutes.CreateTraining.routeName) {
            TeacherCreateTrainingScreen {
                navHostController.popBackStack()
            }
        }
    }
}

sealed class TeacherRoutes(override val routeName: String): NavigationRoute {
    object Home: TeacherRoutes("home")
    object CreateTraining: TeacherRoutes("training/create")
}
