package com.drawiin.common_ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.common_ui.theme.OnSurface

@Composable
fun NavigationAppBar(
    modifier: Modifier = Modifier,
    title: String = "",
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onLeadingClicked: () -> Unit = {},
    onTrailingClicked: () -> Unit = {}
) {
    Row(
        modifier
            .fillMaxWidth()
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onLeadingClicked) {
            leadingIcon?.let { Icon(imageVector = it, contentDescription = null, tint = OnSurface) }
        }
        Text(text = title, style = MaterialTheme.typography.h6.copy(color = OnSurface))
        IconButton(onClick = onTrailingClicked) {
            trailingIcon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = OnSurface
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationAppBarPreview() {
    FunFitTheme {
        NavigationAppBar(
            title = "Navigation",
            leadingIcon = Icons.Default.ArrowBack,
            trailingIcon = Icons.Default.Share
        )
    }
}
