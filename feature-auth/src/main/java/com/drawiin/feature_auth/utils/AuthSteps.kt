package com.drawiin.feature_auth.presentation.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.drawiin.common_ui.composables.TextInput
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.Values
import com.drawiin.feature_auth.R


@Composable
fun AuthNameStep(
    value: String,
    onValueChanged: (String) -> Unit
) {
    TextFieldStep(
        title = stringResource(id = R.string.auth_step_name),
        fieldLabel = stringResource(id = R.string.auth_field_name),
        value = value,
        onValueChanged = onValueChanged
    )
}

@Composable
fun AuthEmailStep(
    value: String,
    onValueChanged: (String) -> Unit
) {
    TextFieldStep(
        title = stringResource(id = R.string.auth_step_email),
        fieldLabel = stringResource(id = R.string.auth_field_email),
        value = value,
        onValueChanged = onValueChanged
    )
}

@Composable
fun AuthCreatePasswordStep(
    value: String,
    onValueChanged: (String) -> Unit
) {
    TextFieldStep(
        title = stringResource(id = R.string.auth_step_password),
        fieldLabel = stringResource(id = R.string.auth_field_password),
        value = value,
        onValueChanged = onValueChanged,
        hidden = true
    )
}

@Composable
fun TextFieldStep(
    title: String,
    fieldLabel: String,
    value: String,
    onValueChanged: (String) -> Unit,
    hidden: Boolean = false
) {
    Column(Modifier.fillMaxSize().padding(horizontal = Padding.small)) {
        Text(text = title, style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(Values.x8))
        TextInput(
            modifier = Modifier.fillMaxWidth(),
            label = fieldLabel,
            value = value,
            onValueChanged = onValueChanged,
            visualTransformation = if (hidden) PasswordVisualTransformation() else VisualTransformation.None
        )
    }
}
