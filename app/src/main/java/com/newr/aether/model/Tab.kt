package com.newr.aether.model

data class Tab(
    val id: String,
    val url: String,
    val title: String,
    val isPrivate: Boolean = false,
    val favicon: String? = null,
    val lastAccessed: Long = System.currentTimeMillis()
)
