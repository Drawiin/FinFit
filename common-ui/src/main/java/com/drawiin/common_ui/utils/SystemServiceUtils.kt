package com.drawiin.common_ui.utils

import android.content.ClipboardManager
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import com.drawiin.utils.extensions.getClipBoardManager

@Composable
@ReadOnlyComposable
fun rememberClipboardManager(): ClipboardManager = rememberContext().getClipBoardManager()

@Composable
@ReadOnlyComposable
fun rememberContext(): Context = LocalContext.current
