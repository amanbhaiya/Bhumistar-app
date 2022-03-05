package com.digitalamanmedia.bhumistar.persentation.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.digitalamanmedia.bhumistar.core.Commons.Companion.BOOLEAN
import kotlinx.coroutines.flow.first
private val Context.dataStore: DataStore<Preferences>
        by preferencesDataStore(name = BOOLEAN)
class DataPreference (private val context: Context){


    suspend fun save(key:String, value:Boolean){
        val dataStoreKey = booleanPreferencesKey(key)
        context.dataStore.edit {
            it[dataStoreKey] = value
        }

    }
    suspend fun read(key:String): Boolean?{
        val dataStoreKey = booleanPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[dataStoreKey]
        }


}