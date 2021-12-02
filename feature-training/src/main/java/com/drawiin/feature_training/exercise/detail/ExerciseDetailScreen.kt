package com.drawiin.feature_training.exercise.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.drawiin.common_ui.composables.DifficultyBadge
import com.drawiin.common_ui.composables.NavigationAppBar
import com.drawiin.common_ui.composables.PrimaryButton
import com.drawiin.common_ui.theme.OnSurface
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.PrimaryColor
import com.drawiin.common_ui.theme.Values
import com.drawiin.core.model.Exercise
import com.drawiin.feature_training.R
import com.drawiin.utils.exercises
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun ExerciseDetailScreen() {
    val pagerState = rememberPagerState()
    val images = listOf(
        R.mipmap.ex_01_01,
        R.mipmap.ex_01_02
    )
    val exercise = exercises[0]
    ExerciseDetailBody(images = images, pageState = pagerState, exercise)
}

@ExperimentalPagerApi
@Composable
fun ExerciseDetailBody(@DrawableRes images: List<Int>, pageState: PagerState, exercise: Exercise) {
    Scaffold(
        topBar = {
            NavigationAppBar(
                leadingIcon = Icons.Default.ArrowBack,
                title = stringResource(id = R.string.exercise_details)
            )
        }
    ) {
        Column(
            modifier = Modifier.verticalScroll(
                rememberScrollState()
            )
        ) {
            ImagesCarousel(images, pageState)
            Spacer(modifier = Modifier.height(Values.x6))
            ExerciseInfo(exercise)
            Spacer(modifier = Modifier.height(Values.x8))
            ActionButton()
        }
    }
}

@Composable
private fun ExerciseInfo(exercise: Exercise) {
    Column(Modifier.padding(horizontal = Padding.small)){
        Text(text = exercise.title, style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(Values.x1))
        Text(
            text = "\uD83D\uDD52${exercise.duration}min",
            style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(Values.x2))
        DifficultyBadge(difficulty = exercise.difficulty)
        Spacer(modifier = Modifier.height(Values.x4))
        Text(
            text = exercise.description,
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
private fun ActionButton() {
    Box(
        Modifier
            .padding(horizontal = Padding.small)
            .padding(bottom = Padding.medium)
    ) {
        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.exercise_start_exercise),
            onClick = {}
        )
    }
}

@ExperimentalPagerApi
@Composable
private fun ImagesCarousel(
    images: List<Int>,
    pageState: PagerState
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(Values.x4))
        HorizontalPager(
            count = images.size,
            state = pageState,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth(),
        ) { page ->
            ImageCarouselBody(images, page)
        }
        Spacer(modifier = Modifier.height(Values.x4))
        HorizontalPagerIndicator(
            pagerState = pageState,
            activeColor = PrimaryColor,
            inactiveColor = OnSurface.copy(alpha = 0.7f),
            indicatorWidth = Values.x3,
            spacing = Values.x1
        )
    }
}

@Composable
private fun ImageCarouselBody(images: List<Int>, page: Int) {
    Box(
        modifier = Modifier
            .padding(horizontal = Padding.small)
            .clip(MaterialTheme.shapes.large)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
    }
}
