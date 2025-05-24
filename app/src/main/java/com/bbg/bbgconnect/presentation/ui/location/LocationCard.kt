package com.bbg.bbgconnect.presentation.ui.location

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bbg.bbgconnect.data.models.Location
import com.bbg.bbgconnect.presentation.ui.location.helper.toMap

/**
 * Created by Enoklit on 21.05.2025.
 */

@Composable
fun LocationCard(
    location: Location,
    getLocalizedText: (Map<String, String>) -> String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .height(160.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = location.image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Black.copy(alpha = 0.3f))
        )

        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = getLocalizedText(location.name.toMap()),
                color = Color.White,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${getLocalizedText(location.city.toMap())}, ${getLocalizedText(location.country.toMap())}",
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}


