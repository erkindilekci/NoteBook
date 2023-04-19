package com.erkindilekci.notebook.noteaddscreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.erkindilekci.notebook.room.Note

@Composable
fun NoteAddScreen(navController: NavController, viewModel: NoteAddScreenViewModel = hiltViewModel()) {
    var title by rememberSaveable{ mutableStateOf("")}
    var desc by rememberSaveable{ mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            NoteAddTopAppBar()
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(it), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(40.dp))

                OutlinedTextField(value = title, onValueChange = {title = it},modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                    singleLine = true,
                    label = { Text(text = "Title") },
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    shape = RoundedCornerShape(10)
                )

                Spacer(modifier = Modifier.heightIn(20.dp))

                OutlinedTextField(value = desc, onValueChange = {desc = it},modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                    singleLine = false,
                    label = { Text(text = "Note") },
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.None
                    ),
                    shape = RoundedCornerShape(10)
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (title.trim().isEmpty() && desc.trim().isEmpty()){
                    viewModel.showToast()
                } else {
                    val newTitle = title
                    val newDesc = desc
                    val newNote = Note(newTitle, newDesc)

                    viewModel.addNote(newNote)

                    navController.navigate("notelist")
                }
            }) {
                Icon(imageVector = Icons.Default.Done, contentDescription = null)
            }
        }
    )
}
