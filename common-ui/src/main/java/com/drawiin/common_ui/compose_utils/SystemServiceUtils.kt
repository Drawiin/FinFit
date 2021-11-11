package com.drawiin.common_ui.compose_utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import com.drawiin.funfit.utils.extensions.getClipBoardManager

@Composable
@ReadOnlyComposable
fun rememberClipboardManager()= rememberContext().getClipBoardManager()

@Composable
@ReadOnlyComposable
fun rememberContext() = LocalContext.current
