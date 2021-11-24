package com.drawiin.feature_training.exercise.help

import android.os.CountDownTimer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.drawiin.common_ui.composables.NavigationAppBar
import com.drawiin.common_ui.composables.PrimaryButton
import com.drawiin.common_ui.composables.SecondaryButton
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Values
import com.drawiin.feature_training.R
import com.drawiin.utils.TimeUtils
import com.drawiin.utils.exercises

@Composable
fun ExerciseHelpScreen(onBackPressed: () -> Unit) {
    val exercise = remember {
        exercises[0]
    }


    var state by remember {
        TimeUtils.minutesToSeconds(exercise.duration.toLong())
            .let { ExerciseHelpState.NotStarted(it) }
            .let { mutableStateOf<ExerciseHelpState>(it) }
    }

    val createTimer = { time: Long ->
        object : CountDownTimer(time, 1000L) {
            override fun onTick(timeInMiliseconds: Long) {
                state = TimeUtils.millisecondsToSeconds(timeInMiliseconds)
                    .let { ExerciseHelpState.Ticking(it) }
            }

            override fun onFinish() {

            }

        }
    }

    var timer by remember {
        mutableStateOf(
            TimeUtils.minutesToSeconds(exercise.duration.toLong())
                .let { TimeUtils.secondsToMilliseconds(it) }
                .let(createTimer)
        )
    }

    val resetTimer = {
        timer = TimeUtils.minutesToSeconds(exercise.duration.toLong())
            .let { TimeUtils.secondsToMilliseconds(it) }
            .let(createTimer)
    }

    val startTimer = {
        timer.start()
    }

    val cancelTimer = {
        timer.cancel()
    }

    val resetState = {
        state = TimeUtils.minutesToSeconds(exercise.duration.toLong())
            .let {ExerciseHelpState.NotStarted(it)}
    }

    ExerciseHelpBody(
        onBackPressed = onBackPressed,
        title = exercise.title,
        description = exercise.description,
        state = state,
        onPrimaryClicked = {
            resetTimer()
            startTimer()
        },
        onSecondaryClicked = {
            cancelTimer()
            resetTimer()
            resetState()
        },
        onRestartExerciseClicked = {
            cancelTimer()
            resetTimer()
            startTimer()
        }
    )
}

@Composable
private fun ExerciseHelpBody(
    onBackPressed: () -> Unit,
    title: String,
    description: String,
    state: ExerciseHelpState,
    onPrimaryClicked: () -> Unit,
    onSecondaryClicked: () -> Unit,
    onRestartExerciseClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = title,
                state = state,
                onBackPressed = onBackPressed,
                onRestartExerciseClicked = onRestartExerciseClicked
            )
        },
        bottomBar = {
            ActionButtons(
                onPrimaryClicked = onPrimaryClicked,
                onSecondaryClicked = onSecondaryClicked,
                state = state
            )
        }
    ) {
        Box(Modifier.padding(it)) {
            TimerBody(
                timeInSeconds = state.timeInSeconds,
                description = description
            )
        }
    }
}

@Composable
private fun TopAppBar(
    title: String,
    state: ExerciseHelpState,
    onBackPressed: () -> Unit,
    onRestartExerciseClicked: () -> Unit
) {
    when (state) {
        is ExerciseHelpState.NotStarted -> NavigationAppBar(
            leadingIcon = Icons.Default.Close,
            onLeadingClicked = onBackPressed,
            title = title
        )
        is ExerciseHelpState.Ticking -> NavigationAppBar(
            leadingIcon = Icons.Default.Close,
            onLeadingClicked = onBackPressed,
            title = title,
            trailingIcon = Icons.Default.Refresh,
            onTrailingClicked = onRestartExerciseClicked
        )
    }
}

@Composable
fun TimerBody(timeInSeconds: Long, description: String) {
    Column(
        Modifier
            .padding(horizontal = Padding.small)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(Values.x8))
        Text(description, style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "${timeInSeconds / 60}:${(timeInSeconds % 60).toString().padStart(2, '0')}",
            style = MaterialTheme.typography.h1
        )
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ActionButtons(
    onPrimaryClicked: () -> Unit,
    onSecondaryClicked: () -> Unit,
    state: ExerciseHelpState
) {
    Column(
        Modifier
            .padding(horizontal = Padding.small)
            .padding(bottom = Padding.medium)
    ) {
        when (state) {
            is ExerciseHelpState.NotStarted -> PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.exercise_help_start_timer),
                icon = Icons.Default.PlayArrow,
                onClick = onPrimaryClicked
            )
            is ExerciseHelpState.Ticking -> {
                SecondaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.exercise_help_cancel_timer),
                    icon = Icons.Default.Close,
                    onClick = onSecondaryClicked
                )
            }
        }


    }
}

sealed class ExerciseHelpState(open val timeInSeconds: Long) {
    data class NotStarted(override val timeInSeconds: Long) : ExerciseHelpState(timeInSeconds)
    data class Ticking(override val timeInSeconds: Long) : ExerciseHelpState(timeInSeconds)
}
