package com.newr.aether.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.newr.aether.ui.components.NavigationBar
import com.newr.aether.ui.components.URLBar
import com.newr.aether.ui.components.WebViewContainer
import com.newr.aether.viewmodel.BrowserViewModel

@Composable
fun BrowserScreen(
    viewModel: BrowserViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val currentTab by viewModel.currentTab.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            Column {
                URLBar(
                    url = currentTab?.url ?: "",
                    isPrivate = currentTab?.isPrivate ?: false,
                    onUrlChange = { viewModel.updateUrl(it) },
                    onSearch = { viewModel.search(it) },
                    onPrivateToggle = { viewModel.togglePrivateMode() }
                )
            }
        },
        bottomBar = {
            NavigationBar(
                onBack = { viewModel.goBack() },
                onForward = { viewModel.goForward() },
                onHome = { viewModel.goHome() },
                onMenu = { viewModel.toggleMenu() }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                WebViewContainer(
                    url = currentTab?.url ?: "about:blank",
                    onUrlChange = { viewModel.updateUrl(it) }
                )
            }
        }
    )
}
