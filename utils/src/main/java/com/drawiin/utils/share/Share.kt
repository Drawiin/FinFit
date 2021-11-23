package com.drawiin.utils.share

import android.content.Context
import android.content.Intent


fun Context.shareSimpleText(title: String? = null, text: String){
    val intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, text)
        type = "text/plain"
    }

    startActivity(Intent.createChooser(intent, title))
}
