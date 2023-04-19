package com.erkindilekci.notebook.noteaddscreen


import android.app.Application
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.erkindilekci.notebook.repo.NoteRepository
import com.erkindilekci.notebook.room.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteAddScreenViewModel @Inject constructor(private val noteRepo: NoteRepository, private val application: Application): ViewModel() {
    fun addNote(note: Note){
        viewModelScope.launch {
            noteRepo.insertNote(note)
        }
    }

    fun showToast(){
        Toast.makeText(application, "Can't be empty!", Toast.LENGTH_LONG).show()
    }
}
