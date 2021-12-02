package com.drawiin.common_ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.drawiin.common_ui.theme.Border
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.common_ui.theme.OnSurface
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Size

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        contentPadding = PaddingValues(Padding.tiny),
        border = BorderStroke(
            Border.small, OnSurface
        )
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(label, style = MaterialTheme.typography.button.copy(color = OnSurface))
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = label,
                    tint = OnSurface,
                    modifier = Modifier.size(
                        Size.ButtonIcon
                    )
                )
            } ?: Spacer(
                modifier = Modifier.height(
                    Size.ButtonIcon
                )
            )
        }
    }
}

@Preview
@Composable
fun SecondaryButtonPreview() {
    FunFitTheme {
        SecondaryButton(label = "Botão Secundário", icon = Icons.Default.Add) {

        }
    }
}
