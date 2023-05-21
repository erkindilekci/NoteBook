package com.erkindilekci.notebook.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.erkindilekci.notebook.domain.model.Note


@Database(entities = [Note::class], version = 5)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao
}
