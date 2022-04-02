package com.digitalamanmedia.bhumistar.data.local.repositoryImpl


import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.digitalamanmedia.bhumistar.core.Commons.Companion.TRUE
import com.digitalamanmedia.bhumistar.domain.repository.local.OnBoardingDataStoreRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class OnBoardingDataStoreRepositoryImpl @Inject constructor(
    private val preferences: DataStore<Preferences>
):OnBoardingDataStoreRepository {
    override suspend fun OnBoardingKeySave(value: Boolean) {
        preferences.edit {
            it[booleanPreferencesKey(TRUE)] = value
        }
    }

    override suspend fun OnBoardingReadKey(key: String): Boolean? {
        val dataStoreKey = booleanPreferencesKey(key)
        val preference = preferences.data.first()
        return preference[dataStoreKey]

    }
}