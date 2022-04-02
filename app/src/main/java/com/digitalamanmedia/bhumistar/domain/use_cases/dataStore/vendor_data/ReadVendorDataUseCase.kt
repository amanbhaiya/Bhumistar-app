package com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.vendor_data


import com.digitalamanmedia.bhumistar.data.local.dataModal.VendorData

import com.digitalamanmedia.bhumistar.domain.repository.local.VendorStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadVendorDataUseCase @Inject constructor(
    private val vendorStoreRepository: VendorStoreRepository
) {
    suspend operator fun invoke(): Flow<VendorData> {
        return vendorStoreRepository.readVendorData()
    }
}