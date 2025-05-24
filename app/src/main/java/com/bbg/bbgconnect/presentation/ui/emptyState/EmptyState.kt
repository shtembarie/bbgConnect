package com.bbg.bbgconnect.presentation.ui.emptyState

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SearchOff
/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun EmptyState(message: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.SearchOff,
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .padding(bottom = 16.dp),
            tint = LightColors.subtext
        )
        Text(
            text = message,
            fontSize = 16.sp,
            color = LightColors.subtext
        )
    }
}