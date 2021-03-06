package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel

import androidx.navigation.NavController

sealed class UserUiEvent {
    data class EnterNumber(val number:String):UserUiEvent()
    data class EnterOTP(val OTP:String):UserUiEvent()
    data class EnterName(val name:String):UserUiEvent()
    data class EnterPassword(val password:String):UserUiEvent()
    data class EnterEmail(val email:String):UserUiEvent()
    data class EnterLoginEmail(val loginEmail:String):UserUiEvent()
    data class EnterLoginPassword(val loginPassword:String):UserUiEvent()
    data class EnterForgotCnfPassword(val forgotCnfPassword:String):UserUiEvent()
    data class EnterForgotEmail(val forgotEmail:String):UserUiEvent()
    data class EnterForgotPassword(val forgotPassword:String):UserUiEvent()
    object GetOTP: UserUiEvent()
    object VerifyOTP: UserUiEvent()
    data class RegisterUser(val navControllerRoot: NavController,val from:Int): UserUiEvent()
    object SavePassword: UserUiEvent()
    data class LoginUser(val navControllerRoot: NavController,val from: Int): UserUiEvent()
    object ForgotCheckEmail: UserUiEvent()
    object ForgotTextClick: UserUiEvent()
    object LoginTextClick: UserUiEvent()
    object RegisterTextClick: UserUiEvent()
    object TogglePasswordVisibility: UserUiEvent()
}