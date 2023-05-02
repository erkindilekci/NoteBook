package com.erkindilekci.notebook.notelistscreen

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erkindilekci.notebook.repo.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteListScreenViewModel @Inject constructor(private val noteRepository: NoteRepository): ViewModel() {
    val noteList = noteRepository.getNotes()

    fun deleteNote(note_id: Int){
        viewModelScope.launch {
            noteRepository.deleteNote(note_id)
        }
    }

    fun onBackClick(){

    }
}
