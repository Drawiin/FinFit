package com.drawiin.feature_teacher

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.drawiin.core.arch.NavigationRoute

fun NavGraphBuilder.addTeacherNavGraph(navHostController: NavHostController, routeName: String){
    navigation(route = routeName, startDestination = TeacherRoutes.Home.routeName){
        composable(TeacherRoutes.Home.routeName){

        }
        composable(TeacherRoutes.CreateTraining.routeName){

        }
    }
}

sealed class TeacherRoutes(override val routeName: String): NavigationRoute {
    object Home: TeacherRoutes("home")
    object CreateTraining: TeacherRoutes("training/create")
}
