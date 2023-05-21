package com.erkindilekci.notebook.presentation.notedetailscreen

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erkindilekci.notebook.domain.repo.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailScreenViewModel @Inject constructor(private val noteRepository: NoteRepository, private val application: Application): ViewModel() {
    fun updateNote(note_id: Int, note_title: String, note_description: String){
        viewModelScope.launch {
            noteRepository.updateNote(note_id, note_title, note_description)
        }
    }
    fun showToast(){
        Toast.makeText(application, "Can't be empty!", Toast.LENGTH_LONG).show()
    }
}
