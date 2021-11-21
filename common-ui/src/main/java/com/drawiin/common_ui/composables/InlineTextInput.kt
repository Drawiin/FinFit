package com.drawiin.common_ui.composables

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.drawiin.common_ui.theme.FunFitTheme

@Composable
fun InlineTextInput(modifier: Modifier = Modifier, value: String, onValueChanged: (String) -> Unit, textStyle: TextStyle = MaterialTheme.typography.h3) {
    BasicTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = modifier,
        textStyle = textStyle
    )
}

@Preview(showBackground = true)
@Composable
fun InlineTextInputPreview() {
    FunFitTheme {
        InlineTextInput(value = "Titulo", onValueChanged = {})
    }
}
