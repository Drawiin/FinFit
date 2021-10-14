package com.drawiin.funfit.utils.extensions

import android.content.ClipboardManager
import android.content.Context

fun Context.getClipBoardManager() = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager