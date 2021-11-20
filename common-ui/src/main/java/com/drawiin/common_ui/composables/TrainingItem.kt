package com.drawiin.common_ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.drawiin.common_ui.theme.Border
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.common_ui.theme.OnSurface
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Values

@ExperimentalMaterialApi
@Composable
fun TrainingItem(
    modifier: Modifier = Modifier,
    title: String,
    quantity: Int,
    onClick: () -> Unit
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        onClick = onClick,
        role = Role.Button,
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        border = BorderStroke(Border.small, MaterialTheme.colors.onSurface),
        color = Color.Transparent
    ) {
        Column(
            modifier
                .fillMaxWidth().wrapContentHeight()
                .padding(Padding.small)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.h5.copy(color = OnSurface),
            )
            Spacer(modifier = Modifier.height(Values.x2))
            Text(
                text = "\uD83C\uDFC3\u200D♀️ $quantity Exercicios",
                style = MaterialTheme.typography.caption.copy(color = OnSurface),
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TrainingItemPreview() {
    FunFitTheme {
        TrainingItem(title = "Treino", quantity = 5) {

        }
    }
}
