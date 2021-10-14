package com.drawiin.funfit.compose_utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import com.drawiin.funfit.utils.extensions.getClipBoardManager

@Composable
@ReadOnlyComposable
fun getClipboardManager()= context().getClipBoardManager()

@Composable
@ReadOnlyComposable
fun context() = LocalContext.current
