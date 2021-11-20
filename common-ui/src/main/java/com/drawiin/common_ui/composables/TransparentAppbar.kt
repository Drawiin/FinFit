package com.drawiin.common_ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.drawiin.common_ui.theme.OnSurface
import com.drawiin.common_ui.theme.Padding

@Composable
fun TransparentAppBar(title: String,onNavClick: () -> Unit) {    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = Padding.medium)
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onNavClick) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Voltar", tint = OnSurface)
        }
        Text(text = title, style = MaterialTheme.typography.h6)
    }
}
