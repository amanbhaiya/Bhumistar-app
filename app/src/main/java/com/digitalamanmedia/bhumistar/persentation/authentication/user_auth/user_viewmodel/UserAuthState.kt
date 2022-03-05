package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel

data class UserAuthState(
    val phone_number: String = "",
    val user_name: String = "",
    val number_OTP: String = "",
    val user_email: String = "",
    val btn_enabled: Boolean = false
)