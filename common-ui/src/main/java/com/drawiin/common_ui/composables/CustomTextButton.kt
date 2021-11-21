package com.drawiin.common_ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.PrimaryColor
import com.drawiin.common_ui.theme.Size

@Composable
fun CustomTextButton(
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(Padding.small),
    ) {

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                label,
                style = MaterialTheme.typography
                    .button
                    .copy(
                        color = PrimaryColor,
                    )
            )
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = label,
                    tint = PrimaryColor,
                    modifier = Modifier.size(
                        Size.ButtonIcon
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun TextButtonPreview() {
    FunFitTheme {
        CustomTextButton(label = "Botão Secundário", icon = Icons.Default.Add) {

        }
    }
}
