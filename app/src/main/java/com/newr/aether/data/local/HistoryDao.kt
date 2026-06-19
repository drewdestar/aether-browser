package com.newr.aether.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.newr.aether.model.History
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert
    suspend fun insert(history: History)

    @Update
    suspend fun update(history: History)

    @Delete
    suspend fun delete(history: History)

    @Query("SELECT * FROM history ORDER BY visitedAt DESC")
    fun getAllHistory(): Flow<List<History>>

    @Query("SELECT * FROM history WHERE url = :url LIMIT 1")
    suspend fun getHistoryByUrl(url: String): History?

    @Query("DELETE FROM history WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM history")
    suspend fun deleteAll()

    @Query("DELETE FROM history WHERE visitedAt < :timestamp")
    suspend fun deleteHistoryBefore(timestamp: Long)
}
