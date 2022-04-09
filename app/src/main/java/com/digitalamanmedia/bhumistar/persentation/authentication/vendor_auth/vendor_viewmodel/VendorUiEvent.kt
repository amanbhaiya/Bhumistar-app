package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_viewmodel

import androidx.navigation.NavController


sealed class VendorUiEvent {
    data class EnterVendorType(val vendorType:String): VendorUiEvent()
    data class EnterNumber(val number:String): VendorUiEvent()
    data class EnterOTP(val OTP:String): VendorUiEvent()
    data class EnterName(val name:String): VendorUiEvent()
    data class EnterPassword(val password:String): VendorUiEvent()
    data class EnterEmail(val email:String): VendorUiEvent()
    data class EnterLoginNumber(val loginEmail:String): VendorUiEvent()
    data class EnterLoginPassword(val loginPassword:String): VendorUiEvent()
    data class EnterForgotCnfPassword(val forgotCnfPassword:String): VendorUiEvent()
    data class EnterForgotNumber(val forgotNumber:String): VendorUiEvent()
    data class EnterForgotPassword(val forgotPassword:String): VendorUiEvent()

    data class Login(val navControllerRoot: NavController,val from: Int):VendorUiEvent()
    object TogglePasswordVisibilityLogin: VendorUiEvent()
    object SaveNewPassword:VendorUiEvent()
    object ToggleNewPasswordVisibility: VendorUiEvent()
    object VerifyNumberUpdatePassword:VendorUiEvent()
    object ToggleRegisterPasswordVisibility: VendorUiEvent()
    object RegisterPasswordGetOTP:VendorUiEvent()
    object RegisterPasswordVerifyOTP: VendorUiEvent()
    data class RegisterNewVendor(val navControllerRoot: NavController,val from:Int): VendorUiEvent()
    object LoginTextClickPassword:VendorUiEvent()
    object LoginTextClickRegister:VendorUiEvent()
    object RegisterClick:VendorUiEvent()
    object PasswordClick:VendorUiEvent()
}
