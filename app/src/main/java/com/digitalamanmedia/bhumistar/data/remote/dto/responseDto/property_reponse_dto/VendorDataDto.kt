package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.property_reponse_dto

import com.digitalamanmedia.bhumistar.domain.modal.property_modal.VendorDataModal

data class VendorDataDto(
    val created_at: String,
    val id: Int,
    val vendor_email: String,
    val vendor_name: String,
    val vendor_password: String,
    val vendor_phone: String,
    val vendor_type: String
){
    fun toVendorDataModal(): VendorDataModal {
        return VendorDataModal(
            vendor_name = vendor_name,
            vendor_type = vendor_type
        )
    }
}