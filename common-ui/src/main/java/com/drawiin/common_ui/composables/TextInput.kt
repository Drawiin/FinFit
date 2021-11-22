package com.drawiin.common_ui.composables

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.common_ui.theme.OnSurface
import com.drawiin.common_ui.theme.PrimaryColor


@Composable
fun TextInput(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        textStyle = MaterialTheme.typography.h6.copy(color = OnSurface),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = OnSurface,
            focusedBorderColor = PrimaryColor,
            unfocusedBorderColor = OnSurface
        ),
        placeholder = {
            Text(
                label,
                style = MaterialTheme.typography.h6.copy(color = OnSurface.copy(alpha = 0.7f))
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation
    )
}

@Preview(showBackground = true)
@Composable
fun TextInputPreview() {
    FunFitTheme {
        TextInput(value = "", onValueChanged = {}, label = "Código do treino")
    }
}
