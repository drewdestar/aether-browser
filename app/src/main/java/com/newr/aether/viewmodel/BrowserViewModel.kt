package com.newr.aether.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newr.aether.model.Tab
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class BrowserUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val menuOpen: Boolean = false
)

@HiltViewModel
class BrowserViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(BrowserUiState())
    val uiState: StateFlow<BrowserUiState> = _uiState

    private val _tabs = MutableStateFlow<List<Tab>>(emptyList())
    val tabs: StateFlow<List<Tab>> = _tabs

    private val _currentTabIndex = MutableStateFlow(0)
    val currentTabIndex: StateFlow<Int> = _currentTabIndex

    val currentTab: StateFlow<Tab?> = MutableStateFlow(null)

    init {
        createNewTab()
    }

    private fun createNewTab() {
        viewModelScope.launch {
            val newTab = Tab(
                id = System.currentTimeMillis().toString(),
                url = "about:blank",
                title = "New Tab",
                isPrivate = false
            )
            val updatedTabs = _tabs.value + newTab
            _tabs.value = updatedTabs
            _currentTabIndex.value = updatedTabs.size - 1
        }
    }

    fun updateUrl(url: String) {
        viewModelScope.launch {
            val currentIndex = _currentTabIndex.value
            if (currentIndex >= 0 && currentIndex < _tabs.value.size) {
                val updatedTabs = _tabs.value.toMutableList()
                updatedTabs[currentIndex] = updatedTabs[currentIndex].copy(url = url)
                _tabs.value = updatedTabs
            }
        }
    }

    fun search(query: String) {
        val searchUrl = "https://www.duckduckgo.com/?q=${query.replace(" ", "+")}"
        updateUrl(searchUrl)
    }

    fun goBack() {}
    fun goForward() {}
    fun goHome() {
        updateUrl("about:blank")
    }

    fun toggleMenu() {
        _uiState.value = _uiState.value.copy(
            menuOpen = !_uiState.value.menuOpen
        )
    }

    fun togglePrivateMode() {
        viewModelScope.launch {
            val currentIndex = _currentTabIndex.value
            if (currentIndex >= 0 && currentIndex < _tabs.value.size) {
                val updatedTabs = _tabs.value.toMutableList()
                val currentTab = updatedTabs[currentIndex]
                updatedTabs[currentIndex] = currentTab.copy(isPrivate = !currentTab.isPrivate)
                _tabs.value = updatedTabs
            }
        }
    }
}
