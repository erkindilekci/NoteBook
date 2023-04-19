package com.erkindilekci.notebook.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_database")
data class Note(
    val title: String,
    val description: String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)
