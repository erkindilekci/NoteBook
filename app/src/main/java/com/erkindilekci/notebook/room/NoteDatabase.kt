package com.erkindilekci.notebook.room

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Note::class], version = 5)
abstract class NoteDatabase: RoomDatabase() {
    abstract val noteDao: NoteDao
}
