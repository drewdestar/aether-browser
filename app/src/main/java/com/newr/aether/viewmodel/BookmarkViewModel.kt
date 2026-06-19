package com.newr.aether.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newr.aether.data.local.BookmarkDao
import com.newr.aether.model.Bookmark
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val bookmarkDao: BookmarkDao
) : ViewModel() {
    val bookmarks: Flow<List<Bookmark>> = bookmarkDao.getAllBookmarks()

    fun createBookmark() {
        // TODO: Show dialog for creating bookmark
    }

    fun deleteBookmark(id: Long) {
        viewModelScope.launch {
            bookmarkDao.deleteById(id)
        }
    }

    fun addBookmark(title: String, url: String) {
        viewModelScope.launch {
            val bookmark = Bookmark(
                title = title,
                url = url,
                folder = "Default"
            )
            bookmarkDao.insert(bookmark)
        }
    }
}
