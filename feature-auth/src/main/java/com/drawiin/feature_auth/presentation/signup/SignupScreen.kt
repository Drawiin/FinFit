package com.drawiin.feature_auth.presentation.signup

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.drawiin.common_ui.composables.NavigationAppBar
import com.drawiin.common_ui.composables.PrimaryButton
import com.drawiin.common_ui.theme.Padding
import com.drawiin.core.model.UserType
import com.drawiin.feature_auth.R
import com.drawiin.feature_auth.core.model.SignupForm
import com.drawiin.feature_auth.utils.isFinalPage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun SignUpScreen(
    onGoToStudentHome: () -> Unit,
    onGoToTeacherHome: () -> Unit,
    onBackClicked: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState()
    val nextPage: () -> Unit = {
        scope.launch {
            with(pageState) {
                if (!pageState.isFinalPage())
                    animateScrollToPage(currentPage + 1)
            }
        }
    }

    val previousPage: () -> Unit = {
        scope.launch {
            with(pageState) {
                if (pageState.currentPage >= 1)
                    animateScrollToPage(currentPage - 1)
                else
                    onBackClicked()
            }
        }
    }

    val signUpFormState = remember {
        mutableStateOf(
            SignupForm(
                name = "",
                email = "",
                password = "",
                userType = UserType.TEACHER
            )
        )
    }
    val signupSteps = listOf<@Composable () -> Unit>(
        {
            AuthNameStep(
                value = signUpFormState.value.name,
                onValueChanged = {
                    signUpFormState.value = signUpFormState.value.copy(name = it)
                }
            )
        },
        {
            AuthEmailStep(
                value = signUpFormState.value.email,
                onValueChanged = {
                    signUpFormState.value = signUpFormState.value.copy(email = it)
                }
            )
        },
        {
            AuthCreatePasswordStep(
                value = signUpFormState.value.password,
                onValueChanged = {
                    signUpFormState.value = signUpFormState.value.copy(password = it)
                }
            )
        }
    )

    SignUpBody(
        onBackClicked = previousPage,
        pageState,
        nextPage,
        onGoToTeacherHome,
        signupSteps
    )
}

@ExperimentalPagerApi
@Composable
private fun SignUpBody(
    onBackClicked: () -> Unit,
    pageState: PagerState,
    nextPage: () -> Unit,
    onGoToTeacherHome: () -> Unit,
    signupSteps: List<@Composable () -> Unit>
) {
    Scaffold(
        bottomBar = {
            SignUpActionButton(
                nextStep = nextPage,
                signUp = onGoToTeacherHome,
                isFinalStep = pageState.isFinalPage()
            )
        },
        topBar = {
            NavigationAppBar(
                leadingIcon = Icons.Default.ArrowBack,
                onLeadingClicked = onBackClicked
            )
        }
    ) {
        Column { SignUpStepsPager(pageState, signupSteps) }
    }
}

@Composable
private fun SignUpActionButton(
    nextStep: () -> Unit,
    signUp: () -> Unit,
    isFinalStep: Boolean
) {
    Box(
        Modifier
            .padding(horizontal = Padding.small)
            .padding(bottom = Padding.medium)
    ) {
        if (isFinalStep)
            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.signup_create_account),
                onClick = signUp
            )
        else
            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.onboard_button_next),
                icon = Icons.Default.KeyboardArrowRight,
                onClick = nextStep
            )
    }
}

@ExperimentalPagerApi
@Composable
fun SignUpStepsPager(state: PagerState, steps: List<@Composable () -> Unit>) {
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        count = steps.size,
        state = state
    ) { page ->
        steps[page].invoke()
    }
}
