package com.newr.aether.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Shield
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun URLBar(
    url: String,
    isPrivate: Boolean,
    onUrlChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    onPrivateToggle: () -> Unit
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue(url)) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .height(44.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                color = if (isPrivate) MaterialTheme.colorScheme.surface
                else MaterialTheme.colorScheme.surface.copy(alpha = 0.8f)
            ),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Security Icon
            Icon(
                imageVector = if (url.startsWith("https://")) Icons.Outlined.Lock
                else Icons.Outlined.Search,
                contentDescription = "Security",
                modifier = Modifier.size(18.dp),
                tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f)
            )

            // Text Field
            BasicTextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    textFieldValue = newValue
                    onUrlChange(newValue.text)
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp),
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground
                ),
                cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                decorationBox = { innerTextField ->
                    Box {
                        if (textFieldValue.text.isEmpty()) {
                            Text(
                                "Search or enter URL",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.5f)
                            )
                        }
                        innerTextField()
                    }
                }
            )

            // Private Mode Icon
            if (isPrivate) {
                Icon(
                    imageVector = Icons.Outlined.Shield,
                    contentDescription = "Private Mode",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { onPrivateToggle() },
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
