package com.newr.aether.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val url: String,
    val favicon: String? = null,
    val visitedAt: Long = System.currentTimeMillis(),
    val visitCount: Int = 1
)
