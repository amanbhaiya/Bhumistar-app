package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.vendor_response_dto

import com.digitalamanmedia.bhumistar.domain.modal.vendor_response_modal.VendorDataResponseModal

data class VendorDataResponseDto(
    val created_at: String?,
    val id: Int?,
    val vendor_email: String?,
    val vendor_name: String?,
    val vendor_password: String?,
    val vendor_phone: String?,
    val vendor_type: String?
)

fun VendorDataResponseDto.toVendorLoginResponseModal(): VendorDataResponseModal {
    return VendorDataResponseModal(
        id = id,
        vendor_name = vendor_name,
        vendor_email = vendor_email,
        vendor_type = vendor_type,
        vendor_phone = vendor_phone
    )
}