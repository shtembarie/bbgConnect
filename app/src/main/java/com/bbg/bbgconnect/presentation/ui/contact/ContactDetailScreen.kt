package com.bbg.bbgconnect.presentation.ui.contact

/**
 * Created by Enoklit on 21.05.2025.
 */
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bbg.bbgconnect.data.models.Contact
import com.bbg.bbgconnect.data.models.Department
import com.bbg.bbgconnect.data.models.Location
import com.bbg.bbgconnect.presentation.ui.theme.LightColors

@Composable
fun ContactDetailScreen(
    contact: Contact,
    department: Department,
    location: Location,
    isFavorite: Boolean,
    onToggleFavorite: (String) -> Unit
) {
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = contact.photo,
                    contentDescription = null,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.height(16.dp))
            }

            IconButton(onClick = { onToggleFavorite(contact.id) }) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Favorite",
                    tint = if (isFavorite) LightColors.favorite else LightColors.icon
                )
            }
        }

        Text(
            text = contact.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = LightColors.text,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = contact.position,
            fontSize = 18.sp,
            color = LightColors.subtext,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = LightColors.card),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                InfoItemDetailAlignment(icon = Icons.Default.Business, text = department.name)
                InfoItemDetailAlignment(icon = Icons.Default.LocationOn, text = "${location.name}, ${location.city}")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Contact Information",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = LightColors.text,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        ContactButton(
            icon = Icons.Default.Email,
            label = contact.email
        ) {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${contact.email}"))
            context.startActivity(intent)
        }

        ContactButton(
            icon = Icons.Default.Phone,
            label = contact.phone,
            background = LightColors.secondary
        ) {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${contact.phone}"))
            context.startActivity(intent)
        }
    }
}