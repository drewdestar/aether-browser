package com.newr.aether.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "passwords")
data class Password(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val domain: String,
    val username: String,
    val password: String,
    val email: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val lastUsed: Long? = null
)
