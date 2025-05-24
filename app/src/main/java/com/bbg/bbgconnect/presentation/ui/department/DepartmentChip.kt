package com.bbg.bbgconnect.presentation.ui.department
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
/**
 * Created by Enoklit on 21.05.2025.
 */
@Composable
fun DepartmentChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) LightColors.primary else LightColors.card
    val borderColor = if (isSelected) LightColors.primary else LightColors.border
    val textColor = if (isSelected) LightColors.primary else LightColors.text

    Box(
        modifier = Modifier
            .clickable { onClick() }
            .background(backgroundColor, shape = RoundedCornerShape(20.dp))
            .border(1.dp, borderColor, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            color = textColor
        )
    }
}