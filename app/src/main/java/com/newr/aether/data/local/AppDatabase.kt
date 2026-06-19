package com.newr.aether.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.newr.aether.model.Bookmark
import com.newr.aether.model.Download
import com.newr.aether.model.History
import com.newr.aether.model.Note
import com.newr.aether.model.Password

@Database(
    entities = [
        Bookmark::class,
        History::class,
        Download::class,
        Password::class,
        Note::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookmarkDao(): BookmarkDao
    abstract fun historyDao(): HistoryDao
    abstract fun downloadDao(): DownloadDao
    abstract fun passwordDao(): PasswordDao
    abstract fun noteDao(): NoteDao
}
