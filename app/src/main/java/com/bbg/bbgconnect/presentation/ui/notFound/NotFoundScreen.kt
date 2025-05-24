package com.bbg.bbgconnect.presentation.ui.notFound

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
/**
 * Created by Enoklit on 21.05.2025.
 */
@Composable
fun NotFoundScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "This screen doesn't exist.",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = LightColors.text
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextButton(onClick = { navController.navigate("tabs") }) {
            Text(
                text = "Go to home screen!",
                fontSize = 14.sp,
                color = LightColors.primary
            )
        }
    }
}