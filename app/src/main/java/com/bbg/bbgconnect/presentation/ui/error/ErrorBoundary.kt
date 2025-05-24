package com.bbg.bbgconnect.presentation.ui.error

import androidx.compose.runtime.*
/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun ErrorBoundary(
    error: Throwable?,
    onReset: () -> Unit = {},
    content: @Composable () -> Unit
) {
    if (error != null) {
        ErrorScreen(error = error, onReset = onReset)
    } else {
        content()
    }
}

