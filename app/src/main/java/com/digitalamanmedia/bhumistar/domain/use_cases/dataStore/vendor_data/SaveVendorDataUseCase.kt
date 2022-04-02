package com.digitalamanmedia.bhumistar.domain.use_cases.dataStore.vendor_data


import com.digitalamanmedia.bhumistar.data.local.dataModal.VendorData
import com.digitalamanmedia.bhumistar.domain.repository.local.VendorStoreRepository
import javax.inject.Inject

class SaveVendorDataUseCase @Inject constructor(
    private val vendorStoreRepository: VendorStoreRepository
) {
    suspend operator fun invoke(vendorData:VendorData){
         vendorStoreRepository.saveVendorData(vendorData)
    }
}