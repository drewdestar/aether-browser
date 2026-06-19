package com.newr.aether.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "downloads")
data class Download(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val fileName: String,
    val url: String,
    val size: Long,
    val status: String,
    val progress: Int = 0,
    val localPath: String,
    val startedAt: Long = System.currentTimeMillis(),
    val completedAt: Long? = null
)
