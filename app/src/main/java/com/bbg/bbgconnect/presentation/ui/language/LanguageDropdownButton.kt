package com.bbg.bbgconnect.presentation.ui.language

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
import com.bbg.bbgconnect.data.models.Language

/**
 * Created by Enoklit on 23.05.2025.
 */

@Composable
fun LanguageDropdownButton(
    languages: List<Language>,
    currentLanguage: String,
    onLanguageSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isDropdownVisible by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        IconButton(
            onClick = { isDropdownVisible = true },
            modifier = Modifier
                .size(48.dp)
                .background(LightColors.card, shape = CircleShape)
        ) {
            Icon(
                imageVector = Icons.Filled.Language,
                contentDescription = "Change Language",
                tint = LightColors.mapMarker
            )
        }

        DropdownMenu(
            expanded = isDropdownVisible,
            onDismissRequest = { isDropdownVisible = false }
        ) {
            languages.forEach { language ->
                val isActive = language.code == currentLanguage

                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = language.flag, modifier = Modifier.padding(end = 8.dp))
                            Text(text = language.name)
                        }
                    },
                    onClick = {
                        onLanguageSelected(language.code)
                        isDropdownVisible = false
                    },
                    modifier = Modifier
                        .background(
                            color = if (isActive) LightColors.primary.copy(alpha = 0.1f)
                            else LightColors.card
                        )
                )
            }
        }
    }
}

