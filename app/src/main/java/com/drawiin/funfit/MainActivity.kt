package com.drawiin.funfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.drawiin.funfit.`common-ui`.theme.FunFitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FunFitTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Route.Home.routeName) {
                    composable(Route.Home.routeName) {
                        HomeScreen(
                            onGoToStudent = { navController.navigate(Route.Student.routeName) },
                            onGoToTeacher = { navController.navigate(Route.Teacher.routeName) })
                    }
                    composable(Route.Teacher.routeName) {
                        TeacherScreen()
                    }
                    composable(Route.Student.routeName) {
                        StudentScreen()
                    }
                }
            }
        }
    }
}

sealed class Route(val routeName: String) {
    object Home : Route("home")
    object Teacher : Route("teacher")
    object Student : Route("student")
}
