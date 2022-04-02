package com.digitalamanmedia.bhumistar.data.local.repositoryImpl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.core.Commons.Companion.ALREADY_LOGIN_VENDOR
import com.digitalamanmedia.bhumistar.core.Commons.Companion.VENDOR_TYPE
import com.digitalamanmedia.bhumistar.core.Commons.Companion.V_EMAIL
import com.digitalamanmedia.bhumistar.core.Commons.Companion.V_ID
import com.digitalamanmedia.bhumistar.core.Commons.Companion.V_NAME
import com.digitalamanmedia.bhumistar.core.Commons.Companion.V_NUMBER
import com.digitalamanmedia.bhumistar.data.local.dataModal.UserData
import com.digitalamanmedia.bhumistar.data.local.dataModal.VendorData
import com.digitalamanmedia.bhumistar.domain.repository.local.VendorStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class VendorStoreRepositoryImpl @Inject constructor(
    private val preferences: DataStore<Preferences>
) :VendorStoreRepository {
    override suspend fun saveVendorData(vendorData: VendorData) {
        preferences.edit{
            it[stringPreferencesKey(V_NAME)] = vendorData.name?:""
            it[stringPreferencesKey(V_NUMBER)] = vendorData.number?:""
            it[stringPreferencesKey(V_EMAIL)] = vendorData.email?:""
            it[stringPreferencesKey(VENDOR_TYPE)] = vendorData.vendorType?:""
            it[intPreferencesKey(V_ID)] = vendorData.vendor_id?:0
        }
    }

    override suspend fun readVendorData() = preferences.data.catch {
        if (this is IOException) {
            emit(emptyPreferences())
        }
    }.map {
        VendorData(
            name = it[stringPreferencesKey(V_NAME)]?:"",
            number = it[stringPreferencesKey(V_NUMBER)]?:"",
            email = it[stringPreferencesKey(V_EMAIL)]?:"",
            vendorType = it[stringPreferencesKey(VENDOR_TYPE)]?:"",
            vendor_id = it[intPreferencesKey(V_ID)]?:0
        )
    }

    override suspend fun readVendorLogin(key: String): String? {
        val dataStoreKey = stringPreferencesKey(key)
        val preference = preferences.data.first()
        return preference[dataStoreKey]
    }

    override suspend fun createVendorLogin(value: String) {
        preferences.edit {
            it[stringPreferencesKey(Commons.ALREADY_LOGIN_VENDOR)] = value
        }
    }
}