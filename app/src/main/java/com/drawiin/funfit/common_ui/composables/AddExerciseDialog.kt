package com.drawiin.funfit.common_ui.composables

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
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.drawiin.funfit.R

@Composable
fun AddExerciseDialog(
    shouldShowDialog: Boolean,
    onCloseRequested: () -> Unit,
    onFillCode: (String) -> Unit
) {
    var fieldState by remember { mutableStateOf("") }

    val  onDone =  {
        onCloseRequested()
        onFillCode(fieldState)
        fieldState = ""
    }

    if (shouldShowDialog) {
        Dialog(onDismissRequest = onCloseRequested) {
            Surface() {
                Column(Modifier.padding(16.dp)) {
                    Text(
                        text = stringResource(id = R.string.new_exercise),
                        style = MaterialTheme.typography.h6
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    OutlinedTextField(
                        value = fieldState,
                        onValueChange = { newText -> fieldState = newText },
                        keyboardOptions = KeyboardOptions(
                            capitalization = KeyboardCapitalization.Sentences,
                            autoCorrect = true,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { onDone() }
                        ),
                        label = { Text(text = stringResource(id = R.string.exercise_name))}
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        TextButton(onClick = { onDone() }) {
                            Text(text = stringResource(id = R.string.add_new))
                        }
                    }
                }
            }
        }
    }
}