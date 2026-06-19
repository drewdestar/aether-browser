package com.newr.aether.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    var theme by remember { mutableStateOf("System") }
    var privateRelay by remember { mutableStateOf(false) }
    var autoSavePassword by remember { mutableStateOf(true) }
    var blockAllCookies by remember { mutableStateOf(false) }
    var doNotTrack by remember { mutableStateOf(true) }
    var preventCrossTracking by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { },
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            color = MaterialTheme.colorScheme.surface
        )

        // General Section
        SettingsSectionHeader("General")
        SettingItem(
            title = "Theme",
            value = theme,
            onClick = { }
        )
        SettingItem(
            title = "Search Engine",
            value = "DuckDuckGo",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Tab Section
        SettingsSectionHeader("Tab Settings")
        SettingItem(
            title = "Tab Layout",
            value = "Compact",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Privacy & Security Section
        SettingsSectionHeader("Privacy & Security")

        SettingToggleItem(
            title = "Private Relay (VPN)",
            subtitle = "Menyembunyikan IP dan mengenkripsi lalu lintas",
            isChecked = privateRelay,
            onCheckedChange = { privateRelay = it }
        )

        SettingToggleItem(
            title = "Block All Cookies",
            isChecked = blockAllCookies,
            onCheckedChange = { blockAllCookies = it }
        )

        SettingToggleItem(
            title = "Prevent Cross-Site Tracking",
            isChecked = preventCrossTracking,
            onCheckedChange = { preventCrossTracking = it }
        )

        SettingToggleItem(
            title = "Do Not Track",
            isChecked = doNotTrack,
            onCheckedChange = { doNotTrack = it }
        )

        SettingItem(
            title = "Manage Site Data",
            value = "View & Delete",
            onClick = { }
        )

        SettingItem(
            title = "Clear History & Data",
            value = "Clear All",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Manager Section
        SettingsSectionHeader("Password Manager")

        SettingToggleItem(
            title = "Auto-save Passwords",
            isChecked = autoSavePassword,
            onCheckedChange = { autoSavePassword = it }
        )

        SettingItem(
            title = "Manage Passwords",
            value = "View All",
            onClick = { }
        )

        SettingItem(
            title = "Master Password",
            value = "Set Master Password",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Notes Section
        SettingsSectionHeader("Notes")
        SettingItem(
            title = "My Notes",
            value = "Manage Notes",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // AI & Intelligence Section
        SettingsSectionHeader("AI & Intelligence")
        SettingToggleItem(
            title = "Enable AI Features",
            subtitle = "Local AI models untuk productivity",
            isChecked = true,
            onCheckedChange = { }
        )

        SettingItem(
            title = "Download AI Models",
            value = "Manage Models",
            onClick = { }
        )

        SettingItem(
            title = "AI Provider",
            value = "Local (Offline)",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // About Section
        SettingsSectionHeader("About")
        SettingItem(
            title = "Aether Version",
            value = "1.0.0",
            onClick = { }
        )
        SettingItem(
            title = "Privacy Policy",
            value = "Read",
            onClick = { }
        )
        SettingItem(
            title = "Check for Updates",
            value = "Up to date",
            onClick = { }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun SettingsSectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelLarge,
        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    )
}

@Composable
fun SettingItem(
    title: String,
    value: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Text(
                    text = value,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                )
            }
            Icon(
                imageVector = Icons.Outlined.Check,
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
            )
        }
    }
}

@Composable
fun SettingToggleItem(
    title: String,
    subtitle: String? = null,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { onCheckedChange(!isChecked) }
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Medium
                )
                if (subtitle != null) {
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.6f)
                    )
                }
            }
            Switch(
                checked = isChecked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}
