package com.bbg.bbgconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.bbg.bbgconnect.presentation.ui.navigation.NavGraph
import com.bbg.bbgconnect.presentation.ui.theme.BbgConnectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BbgConnectTheme {
                Surface {
                    NavGraph() // 👈 Start your app's navigation here
                }
            }
        }
    }
}

