package com.drawiin.feature_auth

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.drawiin.core.arch.NavigationRoute
import com.drawiin.feature_auth.presentation.onboard.OnboardScreen
import com.drawiin.feature_auth.presentation.signup.SignUpScreen
import com.drawiin.feature_auth.presentation.start.AuthStartScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
fun NavGraphBuilder.addAuthNavGraph(
    navHostController: NavHostController,
    routeName: String,
    goToStudentGraph: () -> Unit,
    goToTeacherGraph : () -> Unit
){
    navigation(route = routeName, startDestination = AuthRoutes.Onboard.routeName) {
        composable(AuthRoutes.Onboard.routeName) {
            OnboardScreen(
                onGoToAuthStart = {
                    navHostController.navigate(AuthRoutes.Start.routeName)
                }
            )
        }

        composable(AuthRoutes.Start.routeName) {
            AuthStartScreen(
                onGoToLogin = {
                   navHostController.navigate(AuthRoutes.LogIn.routeName)
                },
                onGoToSignup = {
                    navHostController.navigate(AuthRoutes.SignUp.routeName)
                }
            )
        }

        composable(AuthRoutes.SignUp.routeName) {
            SignUpScreen(
                onGoToStudentHome = goToStudentGraph,
                onGoToTeacherHome = goToTeacherGraph,
                onBackClicked = {
                    navHostController.popBackStack()
                }
            )
        }

        composable(AuthRoutes.LogIn.routeName) {
            Text(text = "Auth/LogIn", style = MaterialTheme.typography.h3)
        }
    }
}

sealed class AuthRoutes(override val routeName: String): NavigationRoute {
    object Onboard : AuthRoutes("auth/onboard")
    object Start : AuthRoutes("auth/start")
    object SignUp : AuthRoutes("auth/signup")
    object LogIn : AuthRoutes("auth/login")
}
