package com.newr.aether.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newr.aether.data.local.DownloadDao
import com.newr.aether.model.Download
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DownloadViewModel @Inject constructor(
    private val downloadDao: DownloadDao
) : ViewModel() {
    val downloads: Flow<List<Download>> = downloadDao.getAllDownloads()
    
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun deleteDownload(id: Long) {
        viewModelScope.launch {
            downloadDao.deleteById(id)
        }
    }

    fun startDownload(fileName: String, url: String, size: Long) {
        viewModelScope.launch {
            val download = Download(
                fileName = fileName,
                url = url,
                size = size,
                status = "PENDING",
                progress = 0,
                localPath = "/downloads/$fileName"
            )
            downloadDao.insert(download)
        }
    }
}
