package com.bbg.bbgconnect.presentation.ui.brochure

/**
 * Created by Enoklit on 19.05.2025.
 */
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbg.bbgconnect.data.models.Brochure
import androidx.compose.material.icons.filled.InsertDriveFile
import com.bbg.bbgconnect.presentation.ui.theme.LightColors


@Composable
fun BrochureList(brochures: List<Brochure>, getLocalizedText: (Map<String, String>) -> String) {
    if (brochures.isEmpty()) return

    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(
            text = "Brochures",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = LightColors.text,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        brochures.forEach { brochure ->
            val context = LocalContext.current
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(brochure.url))
                        context.startActivity(intent)
                    },
                border = BorderStroke(1.dp, LightColors.border),
                colors = CardDefaults.cardColors(containerColor = LightColors.card)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.InsertDriveFile,
                        contentDescription = null,
                        tint = LightColors.primary
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = getLocalizedText(brochure.title.translations),
                        fontSize = 16.sp,
                        color = LightColors.text
                    )
                }
            }
        }
    }
}
