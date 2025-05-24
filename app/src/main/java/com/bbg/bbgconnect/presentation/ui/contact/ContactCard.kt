package com.bbg.bbgconnect.presentation.ui.contact

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbg.bbgconnect.data.models.Contact
import coil.compose.AsyncImage
import com.bbg.bbgconnect.presentation.ui.theme.LightColors


/**
 * Created by Enoklit on 19.05.2025.
 */
@Composable
fun ContactCard(
    contact: Contact,
    departmentName: String,
    isFavorite: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = LightColors.card)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            AsyncImage(
                model = contact.photo,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = contact.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = LightColors.text
                )
                Text(
                    text = contact.position,
                    fontSize = 14.sp,
                    color = LightColors.subtext
                )
                Text(
                    text = departmentName,
                    fontSize = 12.sp,
                    color = LightColors.primary
                )
            }

            if (isFavorite) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = LightColors.favorite,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}