package com.bbg.bbgconnect.presentation.repository

/**
 * Created by Enoklit on 19.05.2025.
 */
import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "favorites_storage")

class FavoritesRepository(private val context: Context) {
    private val FAVORITES_KEY = stringSetPreferencesKey("favorites")

    val favoritesFlow: Flow<Set<String>> = context.dataStore.data.map {
        it[FAVORITES_KEY] ?: emptySet()
    }

    suspend fun addFavorite(contactId: String) {
        context.dataStore.edit { prefs ->
            val current = prefs[FAVORITES_KEY] ?: emptySet()
            prefs[FAVORITES_KEY] = current + contactId
        }
    }

    suspend fun removeFavorite(contactId: String) {
        context.dataStore.edit { prefs ->
            val current = prefs[FAVORITES_KEY] ?: emptySet()
            prefs[FAVORITES_KEY] = current - contactId
        }
    }

    fun isFavorite(contactId: String, favorites: Set<String>): Boolean {
        return favorites.contains(contactId)
    }
}