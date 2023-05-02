package com.erkindilekci.notebook.notelistscreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.erkindilekci.notebook.MainBannerAdView
import com.erkindilekci.notebook.ui.theme.*
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
                //.background(Blue200)
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
            ExtendedFloatingActionButton(
                text = {  Text(text = "Add") },
                onClick = { navController.navigate("noteadd") },
                icon ={ Icon(Icons.Filled.Add,null)},
                contentColor = Color.White, backgroundColor = Blue600
            )
            /*FloatingActionButton(onClick = { navController.navigate("noteadd") }, contentColor = Color.White, backgroundColor = Blue600) {
                Row {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            }*/
        },
        bottomBar = {
            MainBannerAdView()
        }
    )

    BackHandler(onBack = {
        viewModel.onBackClick()
    })
}
