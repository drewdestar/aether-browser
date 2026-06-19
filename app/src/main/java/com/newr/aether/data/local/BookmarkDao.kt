package com.newr.aether.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.newr.aether.model.Bookmark
import kotlinx.coroutines.flow.Flow

@Dao
interface BookmarkDao {
    @Insert
    suspend fun insert(bookmark: Bookmark)

    @Update
    suspend fun update(bookmark: Bookmark)

    @Delete
    suspend fun delete(bookmark: Bookmark)

    @Query("SELECT * FROM bookmarks ORDER BY createdAt DESC")
    fun getAllBookmarks(): Flow<List<Bookmark>>

    @Query("SELECT * FROM bookmarks WHERE folder = :folder ORDER BY createdAt DESC")
    fun getBookmarksByFolder(folder: String): Flow<List<Bookmark>>

    @Query("SELECT * FROM bookmarks WHERE url = :url LIMIT 1")
    suspend fun getBookmarkByUrl(url: String): Bookmark?

    @Query("DELETE FROM bookmarks WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM bookmarks")
    suspend fun deleteAll()
}
