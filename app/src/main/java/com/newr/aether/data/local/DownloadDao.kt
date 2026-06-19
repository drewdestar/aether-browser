package com.newr.aether.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.newr.aether.model.Download
import kotlinx.coroutines.flow.Flow

@Dao
interface DownloadDao {
    @Insert
    suspend fun insert(download: Download)

    @Update
    suspend fun update(download: Download)

    @Delete
    suspend fun delete(download: Download)

    @Query("SELECT * FROM downloads ORDER BY startedAt DESC")
    fun getAllDownloads(): Flow<List<Download>>

    @Query("SELECT * FROM downloads WHERE status = :status")
    fun getDownloadsByStatus(status: String): Flow<List<Download>>

    @Query("DELETE FROM downloads WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM downloads")
    suspend fun deleteAll()
}
