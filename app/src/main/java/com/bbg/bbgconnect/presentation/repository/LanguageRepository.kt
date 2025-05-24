package com.bbg.bbgconnect.presentation.repository

/**
 * Created by Enoklit on 19.05.2025.
 */
import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.bbg.bbgconnect.data.models.Language
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "language_storage")

class LanguageRepository(private val context: Context) {

    private val CURRENT_LANG_KEY = stringPreferencesKey("current_language")

    val languages = listOf(
        Language("en", "English", "🇬🇧"),
        Language("de", "Deutsch", "🇩🇪")
    )

    val currentLanguageFlow: Flow<String> = context.dataStore.data.map {
        it[CURRENT_LANG_KEY] ?: "en"
    }

    suspend fun setLanguage(code: String) {
        context.dataStore.edit { prefs ->
            prefs[CURRENT_LANG_KEY] = code
        }
    }

    fun getLocalizedText(
        langCode: String,
        text: Map<String, String>
    ): String {
        return text[langCode] ?: text["en"] ?: ""
    }
}