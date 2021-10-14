package com.drawiin.funfit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.drawiin.funfit.compose_utils.getClipboardManager
import com.drawiin.funfit.utils.extensions.copyPlainText

@Composable
fun TeacherScreen(exercisesViewModel: ExercisesViewModel = viewModel()) {
    var showAddWordDialog by remember { mutableStateOf(false) }
    var dialogText by remember { mutableStateOf("") }
    var exercises by remember { mutableStateOf(listOf<String>()) }
    val state = exercisesViewModel.state.collectAsState().value

    LocalContext

    when (val currentState = state) {
        is ExerciseState.Empty -> TeacherContent(
            showAddWordDialog = showAddWordDialog,
            dialogText = dialogText,
            exercises = exercises,
            onAddClicked = { showAddWordDialog = true },
            onAddWord = { exercises = exercises + dialogText },
            onDialogTextChanged = { newText -> dialogText = newText },
            onDismissDialog = { showAddWordDialog = false },
            onSaveClicked = { exercisesViewModel.addExercise(exercises) }
        )
        is ExerciseState.Created -> Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                SelectionContainer(){
                    Text(text = currentState.uuid, style = MaterialTheme.typography.h4)
                }
                val onCopyToClipBoard = copyToClipBoard(code = currentState.uuid)
                IconButton(onClick = { onCopyToClipBoard() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_content_copy_24),
                        contentDescription = "copy"
                    )
                }
            }

        }
    }
}

@Composable
fun TeacherContent(
    showAddWordDialog: Boolean,
    dialogText: String,
    exercises: List<String>,
    onAddClicked: () -> Unit,
    onAddWord: () -> Unit,
    onDialogTextChanged: (String) -> Unit,
    onDismissDialog: () -> Unit,
    onSaveClicked: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClicked) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        bottomBar = {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp)){
                Button(onClick = onSaveClicked, Modifier.fillMaxWidth()) {
                    Text(text = "Salvar")
                }
            }
        }
    ) {
        if (showAddWordDialog) {
            if (showAddWordDialog) {
                AlertDialog(
                    onDismissRequest = onDismissDialog,
                    title = {
                        Text(
                            text = "Nova Atividade",
                            style = MaterialTheme.typography.h6
                        )
                    },
                    text = {
                        OutlinedTextField(
                            value = dialogText,
                            onValueChange = onDialogTextChanged,
                            modifier = Modifier,
                            keyboardOptions = KeyboardOptions(
                                capitalization = KeyboardCapitalization.Sentences,
                                autoCorrect = true,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    onDismissDialog()
                                    onAddWord()
                                    onDialogTextChanged("")
                                }
                            )
                        )
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                onDismissDialog()
                                onAddWord()
                                onDialogTextChanged("")
                            }
                        ) {
                            Text(text = "Nova Atividade")
                        }
                    }
                )
            }
        }
        Column(Modifier.fillMaxSize()) {
            LazyColumn(
                contentPadding = PaddingValues(16.dp)
            ) {
                items(exercises) { exercise ->
                    Text(text = "\uD83D\uDC49 $exercise", style = MaterialTheme.typography.h5)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun copyToClipBoard(code: String): () -> Unit {
    val manager = getClipboardManager()
    return {
        manager.copyPlainText(code)
    }
}