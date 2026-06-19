package com.newr.aether.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.newr.aether.model.Password
import kotlinx.coroutines.flow.Flow

@Dao
interface PasswordDao {
    @Insert
    suspend fun insert(password: Password)

    @Update
    suspend fun update(password: Password)

    @Delete
    suspend fun delete(password: Password)

    @Query("SELECT * FROM passwords ORDER BY lastUsed DESC")
    fun getAllPasswords(): Flow<List<Password>>

    @Query("SELECT * FROM passwords WHERE domain = :domain LIMIT 1")
    suspend fun getPasswordByDomain(domain: String): Password?

    @Query("DELETE FROM passwords WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM passwords")
    suspend fun deleteAll()
}
