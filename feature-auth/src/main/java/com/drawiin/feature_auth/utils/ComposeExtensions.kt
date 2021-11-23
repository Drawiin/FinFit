package com.drawiin.feature_auth.utils

import androidx.compose.foundation.MutatePriority
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.launch

@ExperimentalPagerApi
fun PagerState.isFinalPage() = currentPage >= pageCount - 1

@ExperimentalPagerApi
fun PagerState.disableScrolling(scope: CoroutineScope) {
    scope.launch {
        scroll(scrollPriority = MutatePriority.PreventUserInput) {
            awaitCancellation()
        }
    }
}
