package com.erkindilekci.notebook.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM note_database")
    fun getNotes(): Flow<List<Note>>

    @Query("DELETE FROM note_database WHERE id=:note_id")
    suspend fun deleteNote(note_id: Int)

    @Query("UPDATE note_database SET title=:note_title, description=:note_description WHERE id=:note_id")
    suspend fun updateNote(note_id: Int, note_title: String, note_description: String)
}
