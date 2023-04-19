package com.erkindilekci.notebook.util

import android.app.Application
import androidx.room.Room
import com.erkindilekci.notebook.room.NoteDatabase
import com.erkindilekci.notebook.repo.NoteRepository
import com.erkindilekci.notebook.repo.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java, "note_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }
}