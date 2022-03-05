package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_viewmodel

class VendorForgetPasswordState(
    val phone_number: String = "",
    val number_OTP: String = "",
    val vendor_password: String = "",
    val toggle_password_visibility: Boolean = false
)