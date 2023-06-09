package com.erkindilekci.notebook.domain.repo

import com.erkindilekci.notebook.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note_id: Int)

    suspend fun updateNote(note_id: Int, note_title: String, note_desc: String)

    fun getNotes(): Flow<List<Note>>
}