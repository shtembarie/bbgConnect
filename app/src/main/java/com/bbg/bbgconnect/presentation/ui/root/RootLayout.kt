package com.bbg.bbgconnect.presentation.ui.root

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.activity.ComponentActivity
/**
 * Created by Enoklit on 21.05.2025.
 */
@Composable
fun RootLayout(activity: ComponentActivity) {
    // Install splash screen until fonts/assets are "loaded"
    val context = LocalContext.current
    var isReady by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        try {
            // Simulate loading assets/fonts
            kotlinx.coroutines.delay(500)
            isReady = true
        } catch (e: Exception) {
            Log.e("RootLayout", "Error loading assets", e)
        }
    }

    if (!isReady) return

//    AppTheme {
//        ErrorBoundary(error = null) {
//            NavGraph()
//        }
//    }
}

