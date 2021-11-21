package com.drawiin.common_ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Size
import com.drawiin.common_ui.theme.SurfaceColor


@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    Button(onClick = onClick, shape = MaterialTheme.shapes.medium, contentPadding = PaddingValues(Padding.tiny) ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(label, style = MaterialTheme.typography.button)
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = label,
                    tint = SurfaceColor,
                    modifier = Modifier.size(
                        Size.ButtonIcon
                    )
                )
            } ?: Spacer(modifier = Modifier.height(Size.ButtonIcon))
        }
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    FunFitTheme {
        PrimaryButton(label = "Botão primário", icon = Icons.Default.Add) {

        }
    }
}
