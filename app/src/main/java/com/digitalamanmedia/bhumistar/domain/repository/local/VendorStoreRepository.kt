package com.digitalamanmedia.bhumistar.domain.repository.local


import com.digitalamanmedia.bhumistar.data.local.dataModal.VendorData
import kotlinx.coroutines.flow.Flow

interface VendorStoreRepository {

    suspend fun saveVendorData(vendorData: VendorData)

    suspend fun readVendorData(): Flow<VendorData>

    suspend fun readVendorLogin(key:String):String?

    suspend fun createVendorLogin(value:String)
}