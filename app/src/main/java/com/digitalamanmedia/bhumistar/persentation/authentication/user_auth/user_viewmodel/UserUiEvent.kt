package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel

sealed class UserUiEvent {
    data class EnterPhoneNumber(val number:String):UserUiEvent()
    data class EnterOTP(val OTP:String):UserUiEvent()
    data class GetOTP(val getOTPNumber: String): UserUiEvent()
    data class VerifyOTP(val verifyOTP: String): UserUiEvent()
    object SaveUser: UserUiEvent()
}