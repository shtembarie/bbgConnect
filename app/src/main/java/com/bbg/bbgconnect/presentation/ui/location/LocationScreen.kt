package com.bbg.bbgconnect.presentation.ui.location

import android.annotation.SuppressLint
import androidx.collection.mutableIntIntMapOf
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.bbg.bbgconnect.R
import com.bbg.bbgconnect.data.mock.locations
import com.bbg.bbgconnect.data.models.Language
import com.bbg.bbgconnect.data.models.LocalizedText
import com.bbg.bbgconnect.presentation.ui.emptyState.EmptyState
import com.bbg.bbgconnect.presentation.ui.language.LanguageDropdownButton
import com.bbg.bbgconnect.presentation.ui.language.LanguageSelector
import com.bbg.bbgconnect.presentation.ui.theme.LightColors
import com.bbg.bbgconnect.presentation.ui.searchBar.SearchBar
import com.bbg.bbgconnect.presentation.ui.searchBar.StyledSearchBar


/**
 * Created by Enoklit on 21.05.2025.
 */
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LocationsScreen(navController: NavController) {
    var isSearchExpanded by remember { mutableStateOf(false) }
    var currentLanguage by remember { mutableStateOf("en") }
    var searchQuery by remember { mutableStateOf("") }
    var viewMode by remember { mutableStateOf("list") }

    val getLocalizedText: (Map<String, String>) -> String = { map ->
        map[currentLanguage] ?: map["de"] ?: map.values.firstOrNull() ?: "?"
    }

    fun LocalizedText.toMap(): Map<String, String> {
        return mapOf("en" to en, "de" to de) + translations + other
    }
    val filteredLocations by remember(searchQuery, currentLanguage) {
        mutableStateOf(
            if (searchQuery.isBlank()) {
                locations
            } else {
                val query = searchQuery.lowercase()
                locations.filter {
                    getLocalizedText(it.name.toMap()).lowercase().contains(query)
                            || getLocalizedText(it.city.toMap()).lowercase().contains(query)
                            || getLocalizedText(it.country.toMap()).lowercase().contains(query)
                }
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.bitbase_group_logo),
                            contentDescription = "bbg bitbase group Logo",
                            modifier = Modifier
                                .size(48.dp)
                                .padding(end = 8.dp)
                        )
                       Text(
                           text = ("bitbase\nlocations"),
                           fontSize = 16.sp,
                           lineHeight = 13.sp
                       )

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LightColors.background,
                    titleContentColor = LightColors.text,
                ),
                actions = {
                    // 1. Language button (if search not expanded)
                    if (!isSearchExpanded) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(end = 0.dp),
                        ) {
                            LanguageDropdownButton(
                                languages = listOf(
                                    Language("en", "English", "🇬🇧"),
                                    Language("de", "Deutsch", "🇩🇪")
                                ),
                                currentLanguage = currentLanguage,
                                onLanguageSelected = { selected -> currentLanguage = selected },
                                modifier = Modifier.zIndex(0f),

                            )
                        }
                    }

                    // 2. Search bar
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Spacer(modifier = Modifier.width(8.dp))

                        StyledSearchBar(
                            placeholder = "Search locations...",
                            value = searchQuery,
                            onChangeText = { searchQuery = it },
                            modifier = Modifier.zIndex(1f),
                            isExpanded = isSearchExpanded,
                            onExpandChange = { isSearchExpanded = it }
                        )
                    }

                    // 3. View mode switch
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        IconButton(
                            onClick = {
                                viewMode = if (viewMode == "map") "list" else "map"
                            },
                            modifier = Modifier
                                .size(48.dp)
                                .background(LightColors.card, shape = MaterialTheme.shapes.medium)
                                .zIndex(0f)
                        ) {
                            if (viewMode == "map") {
                                Icon(
                                    Icons.Default.List,
                                    contentDescription = "Switch to list",
                                    tint = LightColors.mapMarker
                                )
                            } else {
                                Icon(
                                    Icons.Default.Place,
                                    contentDescription = "Switch to map",
                                    tint = LightColors.mapMarker
                                )
                            }
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Content here
        }
    }


    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(67.dp))
        if (viewMode == "map") {
            if (filteredLocations.isNotEmpty()) {
                LazyColumn(contentPadding = PaddingValues(vertical = 8.dp)) {
                    items(filteredLocations) { location ->
                        LocationCard(
                            location = location,
                            getLocalizedText = getLocalizedText,
                            onClick = { navController.navigate("location/${location.id}") }
                        )
                    }
                }
            } else {
                EmptyState(message = "No locations found. Try a different search term.")
            }
        } else {
            LocationMap(
                locations = filteredLocations,
                selectedLocationId = null,
                getLocalizedText = getLocalizedText,
                onSelectLocation = { locationId ->
                    navController.navigate("location/$locationId")
                }
            )
        }
    }
}

