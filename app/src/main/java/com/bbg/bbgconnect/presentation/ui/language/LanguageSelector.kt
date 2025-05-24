package com.bbg.bbgconnect.presentation.ui.language

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbg.bbgconnect.data.models.Language
import com.bbg.bbgconnect.presentation.ui.theme.LightColors

/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun LanguageSelector(
    languages: List<Language>,
    currentLanguage: String,
    onLanguageSelected: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .background(LightColors.card, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        languages.forEach { language ->
            val isActive = currentLanguage == language.code

            Box( // changed from Row to Box
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .background(
                        color = if (isActive) LightColors.primary else LightColors.card,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .widthIn(min = 100.dp) // Increase horizontal size
                    .clickable { onLanguageSelected(language.code) }
            ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { onLanguageSelected(language.code) }
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .background(
                        color = if (isActive) LightColors.primary else LightColors.card,
                        shape = RoundedCornerShape(6.dp)
                    )
            ) {
                Text(
                    text = language.flag,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(end = 6.dp),
                    color = if (isActive) LightColors.secondary else LightColors.shadow
                )
                Text(
                    text = language.name,
                    fontSize = 14.sp,
                    color = if (isActive) LightColors.secondary else LightColors.shadow
                )
            }
            }
        }
    }
}