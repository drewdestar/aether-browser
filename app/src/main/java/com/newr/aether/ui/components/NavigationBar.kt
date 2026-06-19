package com.newr.aether.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun NavigationBar(
    onBack: () -> Unit,
    onForward: () -> Unit,
    onHome: () -> Unit,
    onMenu: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavigationButton(
            icon = Icons.AutoMirrored.Outlined.ArrowBack,
            contentDescription = "Back",
            onClick = onBack
        )

        NavigationButton(
            icon = Icons.AutoMirrored.Outlined.ArrowForward,
            contentDescription = "Forward",
            onClick = onForward
        )

        NavigationButton(
            icon = Icons.Outlined.Home,
            contentDescription = "Home",
            onClick = onHome
        )

        NavigationButton(
            icon = Icons.Outlined.MoreVert,
            contentDescription = "Menu",
            onClick = onMenu
        )
    }
}

@Composable
fun NavigationButton(
    icon: ImageVector,
    contentDescription: String,
    onClick: () -> Unit
) {
    Icon(
        imageVector = icon,
        contentDescription = contentDescription,
        modifier = Modifier
            .size(24.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .padding(4.dp),
        tint = MaterialTheme.colorScheme.primary
    )
}
