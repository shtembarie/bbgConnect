package com.bbg.bbgconnect.presentation.ui.searchBar

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbg.bbgconnect.presentation.ui.theme.LightColors



/**
 * Created by Enoklit on 21.05.2025.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    placeholder: String,
    value: String,
    onChangeText: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        IconButton(
            onClick = { isExpanded = !isExpanded },
            modifier = Modifier
                .size(48.dp)
                .background(LightColors.card, RoundedCornerShape(12.dp))
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                tint = LightColors.icon
            )
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = androidx.compose.animation.expandHorizontally(animationSpec = tween(300)),
            exit = androidx.compose.animation.shrinkHorizontally(animationSpec = tween(300))
        ) {
            TextField(
                value = value,
                onValueChange = onChangeText,
                placeholder = {
                    Text(text = placeholder, fontSize = 16.sp, color = LightColors.subtext)
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = LightColors.card,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedTextColor = LightColors.text
                )
            )
        }
    }
}