package com.erkindilekci.notebook.notedetailscreen

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
import com.erkindilekci.notebook.noteaddscreen.NoteAddTopAppBar
import com.erkindilekci.notebook.room.Note

@Composable
fun NoteDetailScreen(sentNote: Note, navController: NavController, viewModel: NoteDetailScreenViewModel = hiltViewModel()) {
    var noteTitle by rememberSaveable{ mutableStateOf("") }
    var noteDesc by rememberSaveable{ mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = true){
        noteTitle = sentNote.title
        noteDesc = sentNote.description
    }

    Scaffold(
        topBar = {
            NoteAddTopAppBar()
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(it), horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(40.dp))

                OutlinedTextField(value = noteTitle, onValueChange = {noteTitle = it},modifier = Modifier
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

                OutlinedTextField(value = noteDesc, onValueChange = {noteDesc = it},modifier = Modifier
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
                if (noteTitle.trim().isEmpty() && noteDesc.trim().isEmpty()){
                    viewModel.showToast()
                } else {
                    val newNoteTitle = noteTitle
                    val newNoteDesc = noteDesc
                    val noteId = sentNote.id!!

                    viewModel.updateNote(noteId, noteTitle, noteDesc)

                    navController.navigate("notelist")
                }
            }) {
                Icon(imageVector = Icons.Default.Done, contentDescription = null)
            }
        }
    )
}