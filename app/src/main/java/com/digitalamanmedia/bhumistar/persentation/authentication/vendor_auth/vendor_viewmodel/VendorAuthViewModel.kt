package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel.UserUiEvent
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel.UserAuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//
//@HiltViewModel
//class VendorAuthViewModel @Inject constructor(){
//
//    private val _vendorState = mutableStateOf(UserAuthState())
//    val state: State<UserAuthState> = _vendorState
//
//
//
//    fun onUiEvent(event: VendorUiEvent){
//        when(event){
//
//            // Vendor Login UiEvent
//            VendorUiEvent.Login->{}
//            VendorUiEvent.TogglePasswordVisibilityLogin->{}
//
//            //Forgot Password UiEvent
//            VendorUiEvent.SaveNewPassword->{}
//            VendorUiEvent.ToggleSaveNewPasswordVisibility->{}
//            VendorUiEvent.SaveNewPasswordGetOTP->{}
//            VendorUiEvent.SaveNewPasswordVerifyOTP->{}
//
//            // New Vendor Registration UiEvent
//            VendorUiEvent.RegisterNewVendor->{}
//            VendorUiEvent.RegisterPasswordGetOTP->{}
//            VendorUiEvent.RegisterPasswordVerifyOTP->{}
//            VendorUiEvent.ToggleRegisterPasswordVisibility->{}
//            VendorUiEvent.SetVendorType->{}
//        }
//    }
//}