package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_viewmodel

sealed class VendorUiEvent {

    object Login:VendorUiEvent()
    object TogglePasswordVisibilityLogin: VendorUiEvent()
    object SaveNewPassword:VendorUiEvent()
    object ToggleSaveNewPasswordVisibility: VendorUiEvent()
    object SaveNewPasswordGetOTP:VendorUiEvent()
    object SaveNewPasswordVerifyOTP: VendorUiEvent()
    object SetVendorType:VendorUiEvent()
    object ToggleRegisterPasswordVisibility: VendorUiEvent()
    object RegisterPasswordGetOTP:VendorUiEvent()
    object RegisterPasswordVerifyOTP: VendorUiEvent()
    object RegisterNewVendor: VendorUiEvent()
}
