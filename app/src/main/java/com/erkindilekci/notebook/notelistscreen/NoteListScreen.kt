package com.erkindilekci.notebook.notelistscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.gson.Gson

@Composable
fun NoteListScreen(navController: NavController, viewModel: NoteListScreenViewModel = hiltViewModel()) {
    val noteList = viewModel.noteList.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            NoteListScreenTopAppBar()
        },
        content = {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(it))
            {
                noteList?.let {
                    items(noteList.value){
                        NoteItem(
                            note = it,
                            onDeleteClick = { viewModel.deleteNote(it.id!!) },
                            onItemClick = {
                                val noteJson = Gson().toJson(it)
                                navController.navigate("notedetail/$noteJson")
                            }
                        )
                    }
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("noteadd") }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    )
}
