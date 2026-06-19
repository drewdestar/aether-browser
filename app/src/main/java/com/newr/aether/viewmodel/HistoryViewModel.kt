package com.newr.aether.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newr.aether.data.local.HistoryDao
import com.newr.aether.model.History
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val historyDao: HistoryDao
) : ViewModel() {
    val history: Flow<List<History>> = historyDao.getAllHistory()

    fun deleteHistory(id: Long) {
        viewModelScope.launch {
            historyDao.deleteById(id)
        }
    }

    fun clearAllHistory() {
        viewModelScope.launch {
            historyDao.deleteAll()
        }
    }

    fun addHistory(title: String, url: String) {
        viewModelScope.launch {
            val existingHistory = historyDao.getHistoryByUrl(url)
            if (existingHistory != null) {
                historyDao.update(
                    existingHistory.copy(
                        visitCount = existingHistory.visitCount + 1,
                        visitedAt = System.currentTimeMillis()
                    )
                )
            } else {
                historyDao.insert(
                    History(
                        title = title,
                        url = url
                    )
                )
            }
        }
    }
}
