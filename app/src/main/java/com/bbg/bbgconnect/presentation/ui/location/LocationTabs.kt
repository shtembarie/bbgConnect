package com.bbg.bbgconnect.presentation.ui.location

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbg.bbgconnect.data.models.Tab
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun LocationTabs(
    tabs: List<Tab>,
    activeTab: String,
    getLocalizedText: (Map<String, String>) -> String,
    onChangeTab: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp)
    ) {
        tabs.forEach { tab ->
            val isActive = activeTab == tab.key
            Column(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable { onChangeTab(tab.key) }
            ) {
                Text(
                    text = getLocalizedText(tab.title),
                    fontSize = 16.sp,
                    color = if (isActive) LightColors.primary else LightColors.subtext
                )
                if (isActive) {
                    Spacer(
                        modifier = Modifier
                            .height(2.dp)
                            .width(40.dp)
                            .background(LightColors.primary)
                    )
                }
            }
        }
    }
}
