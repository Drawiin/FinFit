package com.drawiin.funfit.ui

import androidx.compose.runtime.Composable
import com.drawiin.common_ui.theme.FunFitTheme
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
@Composable
fun FunFitApp() {
    FunFitTheme {
        AppNavGraph()
    }
}
