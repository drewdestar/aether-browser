package com.newr.aether.di

import android.content.Context
import androidx.room.Room
import com.newr.aether.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "aether_db"
    ).build()

    @Singleton
    @Provides
    fun provideBookmarkDao(database: AppDatabase) = database.bookmarkDao()

    @Singleton
    @Provides
    fun provideHistoryDao(database: AppDatabase) = database.historyDao()

    @Singleton
    @Provides
    fun providePasswordDao(database: AppDatabase) = database.passwordDao()

    @Singleton
    @Provides
    fun provideNoteDao(database: AppDatabase) = database.noteDao()

    @Singleton
    @Provides
    fun provideDownloadDao(database: AppDatabase) = database.downloadDao()
}
