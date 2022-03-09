package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel

import com.digitalamanmedia.bhumistar.core.Commons.Companion.MESSAGE
import com.digitalamanmedia.bhumistar.domain.modal.NormalResponseModal

data class UserAuthState(
    val phone_number: String = "",
    val user_name: String = "",
    val number_OTP: String = "",
    val user_email: String = "",
    val user_password: String = "",
    val btn_enabled: Boolean = false,
    val message:String = MESSAGE,
    val isLoading:Boolean = false,
)