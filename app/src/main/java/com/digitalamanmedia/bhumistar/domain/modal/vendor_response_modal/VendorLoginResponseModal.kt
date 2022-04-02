package com.digitalamanmedia.bhumistar.domain.modal.vendor_response_modal

import com.digitalamanmedia.bhumistar.domain.modal.vendor_response_modal.VendorDataResponseModal


data class VendorLoginResponseModal(
    val data: VendorDataResponseModal?,
    val message: String,
    val status: Int
)
