package com.newr.aether.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newr.aether.data.local.NoteDao
import com.newr.aether.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteDao: NoteDao
) : ViewModel() {
    val notes: Flow<List<Note>> = noteDao.getAllNotes()
    
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun createNote() {
        // TODO: Show dialog for creating note
    }

    fun deleteNote(id: Long) {
        viewModelScope.launch {
            noteDao.deleteById(id)
        }
    }

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            val note = Note(
                title = title,
                content = content
            )
            noteDao.insert(note)
        }
    }
}
