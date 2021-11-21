package com.drawiin.feature_student

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.drawiin.core.arch.NavigationRoute

fun NavGraphBuilder.addStudentNavGraph(nanController: NavHostController, routeName: String){
    navigation(route = routeName, startDestination = StudentRoutes.Home.routeName){
        composable(StudentRoutes.Home.routeName){

        }
    }
}

sealed class StudentRoutes(override val routeName: String): NavigationRoute {
    object Home: StudentRoutes("home")
}
