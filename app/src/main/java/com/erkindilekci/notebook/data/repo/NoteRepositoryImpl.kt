package com.erkindilekci.notebook.data.repo

import com.erkindilekci.notebook.domain.repo.NoteRepository
import com.erkindilekci.notebook.domain.model.Note
import com.erkindilekci.notebook.data.datasource.NoteDao
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(private val noteDao: NoteDao): NoteRepository {
    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note_id: Int) {
        noteDao.deleteNote(note_id)
    }

    override suspend fun updateNote(note_id: Int, note_title: String, note_desc: String) {
        noteDao.updateNote(note_id, note_title, note_desc)
    }

    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes()
    }
}