package com.drawiin.feature_auth.presentation.onboard

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.drawiin.common_ui.composables.PrimaryButton
import com.drawiin.common_ui.theme.OnSurface
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.PrimaryColor
import com.drawiin.common_ui.theme.Values
import com.drawiin.feature_auth.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import com.drawiin.core.R as CoreR

@ExperimentalPagerApi
@Composable
fun OnboardScreen(onGoToAuthStart: () -> Unit) {
    val pageState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val nextPage: () -> Unit = {
        scope.launch {
            with(pageState) {
                animateScrollToPage(currentPage + 1)
            }
        }
    }
    OnboardScreenBody(onGoToAuthStart, nextPage, pageState)
}

@ExperimentalPagerApi
@Composable
private fun OnboardScreenBody(
    onGoToAuthStart: () -> Unit,
    nextPage: () -> Unit,
    pageState: PagerState
) {
    Scaffold(
        bottomBar = {
            OnboardActionButton(
                goToStart = onGoToAuthStart,
                nextPage = nextPage,
                isFinalPage = pageState.isFinalPage()
            )
        }
    ) { contentPadding ->
        Column(
            Modifier
                .padding(vertical = Padding.medium)
                .padding(contentPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = CoreR.string.app_name),
                style = MaterialTheme.typography.h3
            )
            Carousel(pageState = pageState)
        }
    }
}

@ExperimentalPagerApi
@Composable
fun OnboardActionButton(
    nextPage: () -> Unit,
    goToStart: () -> Unit,
    isFinalPage: Boolean
) {
    Box(
        Modifier
            .padding(horizontal = Padding.small)
            .padding(bottom = Padding.medium)
    ) {
        if (isFinalPage)
            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.onboard_button_lets_play),
                onClick = goToStart
            )
        else
            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                label = stringResource(id = R.string.onboard_button_next),
                icon = Icons.Default.KeyboardArrowRight,
                onClick = nextPage
            )
    }
}

@ExperimentalPagerApi
@Composable
fun Carousel(pageState: PagerState) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(
            count = OnBoardStep.steps.size,
            state = pageState,
            modifier = Modifier.height(300.dp),
            contentPadding = PaddingValues(horizontal = Padding.small)
        ) { page ->
            val (img, description) = OnBoardStep.steps[page]
            CarouselBody(img = img, description = description)
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
fun CarouselBody(
    @DrawableRes img: Int,
    @StringRes description: Int
) {
    Column {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = img),
            contentDescription = stringResource(id = description),
        )
        Spacer(modifier = Modifier.height(Values.x4))
        Text(
            text = stringResource(id = description),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6
        )
    }
}

@ExperimentalPagerApi
private fun PagerState.isFinalPage() = currentPage >= pageCount - 1
