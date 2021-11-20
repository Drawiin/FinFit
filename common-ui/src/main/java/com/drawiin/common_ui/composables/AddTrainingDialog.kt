package com.drawiin.common_ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.drawiin.common_ui.R
import com.drawiin.common_ui.theme.FunFitTheme
import com.drawiin.common_ui.theme.Padding
import com.drawiin.common_ui.theme.SurfaceColor
import com.drawiin.common_ui.theme.Values

@Composable
fun AddTrainingDialog(
    shouldShowDialog: Boolean,
    onCloseRequested: () -> Unit,
    onAddClicked: (String) -> Unit
) {
    var fieldValue by remember { mutableStateOf("") }

    val onCodeFilled = {
        onCloseRequested()
        onAddClicked("")
        fieldValue = ""
    }

    if (shouldShowDialog)
        Dialog(onDismissRequest = onCloseRequested) {
            DialogBody(
                fieldValue = fieldValue,
                onValueChanged = { t -> fieldValue = t },
                onKeyboardAction = onCodeFilled,
                onPositiveButtonClicked = onCodeFilled,
                onNegativeButtonClicked = onCloseRequested
            )
        }

}

@Composable
fun DialogBody(
    fieldValue: String,
    onValueChanged: (String) -> Unit,
    onKeyboardAction: () -> Unit,
    onPositiveButtonClicked: () -> Unit,
    onNegativeButtonClicked: () -> Unit
) {
    val keyBoardOptions = KeyboardOptions(
        capitalization = KeyboardCapitalization.Sentences,
        autoCorrect = true,
        imeAction = ImeAction.Done
    )

    Surface(color = SurfaceColor) {
        Column(Modifier.padding(Padding.small)) {
            Text(
                stringResource(id = R.string.add_training_dialog_title),
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(Values.x4))
            Text(
                stringResource(id = R.string.add_training_dialog_body),
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(Values.x4))
            TextInput(
                label = stringResource(id = R.string.add_training_dialog_input_label),
                value = fieldValue,
                onValueChanged = onValueChanged,
                keyboardOptions = keyBoardOptions,
                modifier = Modifier.fillMaxWidth(),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onKeyboardAction()
                    }
                )
            )
            Spacer(modifier = Modifier.height(Values.x8))
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomTextButton(
                    label = stringResource(id = R.string.add_training_dialog_negative_button),
                    onClick = onNegativeButtonClicked
                )
                CustomTextButton(
                    label = stringResource(id = R.string.add_training_dialog_positive_button),
                    onClick = onPositiveButtonClicked
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddTrainingDialog() {
    FunFitTheme {
        DialogBody(
            onKeyboardAction = {},
            onValueChanged = {},
            onNegativeButtonClicked = {},
            onPositiveButtonClicked = {},
            fieldValue = ""
        )
    }
}
