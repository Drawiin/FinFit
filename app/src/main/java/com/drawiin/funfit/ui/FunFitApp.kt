package com.drawiin.funfit.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import com.drawiin.common_ui.theme.FunFitTheme
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun FunFitApp() {
    FunFitTheme {
        AppNavGraph()
    }
}
