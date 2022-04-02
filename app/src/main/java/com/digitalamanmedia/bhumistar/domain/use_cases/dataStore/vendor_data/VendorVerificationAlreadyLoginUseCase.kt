package com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.vendor_data

import com.digitalamanmedia.bhumistar.domain.repository.local.UserStoreRepository
import com.digitalamanmedia.bhumistar.domain.repository.local.VendorStoreRepository
import javax.inject.Inject

class VendorVerificationAlreadyLoginUseCase @Inject constructor(
    private val vendorStoreRepository: VendorStoreRepository
){
    suspend fun createVendorKey(value:String){
        vendorStoreRepository.createVendorLogin(value)
    }
    suspend fun readVendorrKey(key:String):String?{
        return vendorStoreRepository.readVendorLogin(key)
    }
}