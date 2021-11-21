package com.drawiin.feature_auth

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.drawiin.core.arch.NavigationRoute
import com.drawiin.feature_auth.presentation.onboard.OnboardScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
fun NavGraphBuilder.addAuthNavGraph(navHostController: NavHostController, routeName: String){
    navigation(route = routeName, startDestination = AuthRoutes.Onboard.routeName){
        composable(AuthRoutes.Onboard.routeName){
            OnboardScreen { navHostController.navigate(AuthRoutes.Start.routeName)}
        }

        composable(AuthRoutes.Start.routeName){
            Text(text = "Auth/Start", style = MaterialTheme.typography.h3)
        }

        composable(AuthRoutes.SignUp.routeName){
            Text(text = "Auth/Signup", style = MaterialTheme.typography.h3)
        }
    }
}

sealed class AuthRoutes(override val routeName: String): NavigationRoute {
    object Onboard: AuthRoutes("auth/onboard")
    object Start: AuthRoutes("auth/start")
    object SignUp: AuthRoutes("auth/signup")
}
