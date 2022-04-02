package com.digitalamanmedia.bhumistar.data.remote.dto.responseDto.vendor_response_dto

import com.digitalamanmedia.bhumistar.domain.modal.vendor_response_modal.VendorLoginResponseModal

data class VendorLoginResponseDto(
    val data: VendorDataResponseDto?,
    val message: String,
    val status: Int
)
fun VendorLoginResponseDto.toVendorLoginResponseModal(): VendorLoginResponseModal {
    return VendorLoginResponseModal(
        status = status,
        message = message,
        data = data?.toVendorLoginResponseModal()
    )
}