package com.drawiin.funfit.utils.extensions

import android.content.ClipData
import android.content.ClipboardManager

fun ClipboardManager.copyPlainText(text: String) {
    val clip = ClipData.newPlainText("Code", text)
    setPrimaryClip(clip)
}