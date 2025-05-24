package com.bbg.bbgconnect.presentation.ui.modalScreen


import android.app.Activity
import android.os.Build
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun ModalScreen() {
    val view = LocalView.current
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val window = (view.context as Activity).window
        WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false

    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = LightColors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Modal",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = LightColors.text
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "This is an example modal.\nYou can edit it in ui/modal/ModalScreen.kt.",
                color = LightColors.subtext
            )
        }
    }
}