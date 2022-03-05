package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_viewmodel

data class VendorLoginState(
    val phone_number: String = "",
    val vendor_password: String = "",
    val toggle_password_visibility: Boolean = false
)