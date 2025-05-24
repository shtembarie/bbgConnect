package com.bbg.bbgconnect.presentation.ui.searchBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
/**
 * Created by Enoklit on 23.05.2025.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StyledSearchBar(
    value: String,
    onChangeText: (String) -> Unit,
    placeholder: String = "Search your library",
    onMicClick: () -> Unit = {},
    onProfileClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    onExpandChange: (Boolean) -> Unit
) {
    if (isExpanded) {
        // Full-width search bar
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(LightColors.card, RoundedCornerShape(28.dp))
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onExpandChange(false) }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Collapse search",
                    tint = LightColors.icon
                )
            }

            TextField(
                value = value,
                onValueChange = onChangeText,
                placeholder = {
                    Text(
                        text = placeholder,
                        fontSize = 16.sp,
                        color = LightColors.subtext
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedTextColor = LightColors.text
                ),
                modifier = Modifier.weight(1f)
            )

            IconButton(onClick = onMicClick) {
                Icon(Icons.Default.Mic, contentDescription = "Mic", tint = LightColors.icon)
            }

            IconButton(onClick = onProfileClick) {
                Surface(
                    shape = CircleShape,
                    modifier = Modifier.size(32.dp),
                    color = Color.Gray // Replace with real image if needed
                ) {}
            }
        }
    } else {
        // Only search icon
        IconButton(
            onClick = { onExpandChange(true) },
            modifier = modifier
                .size(48.dp)
                .background(LightColors.card, shape = CircleShape)
        ) {
            Icon(Icons.Default.Search, contentDescription = "Expand Search", tint = LightColors.mapMarker)
        }
    }
}