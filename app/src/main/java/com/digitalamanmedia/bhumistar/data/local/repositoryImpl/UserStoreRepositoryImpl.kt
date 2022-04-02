package com.digitalamanmedia.bhumistar.data.local.repositoryImpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.digitalamanmedia.bhumistar.core.Commons.Companion.ALREADY_LOGIN_USER
import com.digitalamanmedia.bhumistar.core.Commons.Companion.CITY
import com.digitalamanmedia.bhumistar.core.Commons.Companion.EMAIL
import com.digitalamanmedia.bhumistar.core.Commons.Companion.ID
import com.digitalamanmedia.bhumistar.core.Commons.Companion.NAME
import com.digitalamanmedia.bhumistar.core.Commons.Companion.NUMBER
import com.digitalamanmedia.bhumistar.core.Commons.Companion.PIN_CODE
import com.digitalamanmedia.bhumistar.core.Commons.Companion.STATE
import com.digitalamanmedia.bhumistar.data.local.dataModal.UserData
import com.digitalamanmedia.bhumistar.domain.repository.local.UserStoreRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class UserStoreRepositoryImpl @Inject constructor(
    private val preferences: DataStore<Preferences>
):UserStoreRepository {
    override suspend fun saveUserData(userData: UserData) {
        preferences.edit{
            it[intPreferencesKey(ID)] = userData.id?:0
            it[stringPreferencesKey(NAME)] = userData.name?:""
            it[stringPreferencesKey(NUMBER)] = userData.number?:""
            it[stringPreferencesKey(EMAIL)] = userData.email?:""
            it[stringPreferencesKey(STATE)] = userData.state?:""
            it[stringPreferencesKey(CITY)] = userData.district?:""
            it[stringPreferencesKey(PIN_CODE)] = userData.pin_code?:""
        }
    }

    override suspend fun readUserData() = preferences.data.catch {
        if (this is IOException) {
            emit(emptyPreferences())
        }
    }.map {
        UserData(
            id = it[intPreferencesKey(ID)]?:0,
            name = it[stringPreferencesKey(NAME)]?:"",
            number = it[stringPreferencesKey(NUMBER)]?:"",
            email = it[stringPreferencesKey(EMAIL)]?:"",
            state = it[stringPreferencesKey(STATE)]?:"",
            district = it[stringPreferencesKey(CITY)]?:"",
            pin_code = it[stringPreferencesKey(PIN_CODE)]?:""
        )
    }

    override suspend fun readUserLogin(key:String): String? {
        val dataStoreKey = stringPreferencesKey(key)
        val preference = preferences.data.first()
        return preference[dataStoreKey]
    }

    override suspend fun createUserLogin(value:String) {
        preferences.edit {
            it[stringPreferencesKey(ALREADY_LOGIN_USER)] = value
        }
    }


}