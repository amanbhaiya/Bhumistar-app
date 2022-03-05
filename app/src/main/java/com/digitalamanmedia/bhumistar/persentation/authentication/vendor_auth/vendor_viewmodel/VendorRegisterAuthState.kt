package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_viewmodel

data class VendorRegisterAuthState(
    val phone_number: String = "",
    val user_name: String = "",
    val number_OTP: String = "",
    val user_email: String = "",
    val user_password: String = "",
    val user_type: String = "",
    val btn_enabled: Boolean = false
)
