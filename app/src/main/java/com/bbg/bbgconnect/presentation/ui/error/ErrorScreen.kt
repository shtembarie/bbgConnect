package com.bbg.bbgconnect.presentation.ui.error

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbg.bbgconnect.presentation.ui.theme.LightColors

/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun ErrorScreen(error: Throwable, onReset: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Something went wrong",
            fontSize = 22.sp,
            color = LightColors.text
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = error.message ?: "Unknown error",
            color = LightColors.subtext,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onReset) {
            Text("Try Again")
        }
    }
}

