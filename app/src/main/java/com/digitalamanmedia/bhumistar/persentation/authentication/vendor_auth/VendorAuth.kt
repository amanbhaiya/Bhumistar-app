package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.core.utils.SnackBarManager
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel.UserAuthViewModel
import com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_screens.VendorPasswordScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_viewmodel.VendorAuthViewModel
import com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_viewmodel.VendorLoginScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_viewmodel.VendorUiEvent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun VendorAuth(
    viewModel: VendorAuthViewModel = hiltViewModel()
) {



    val state = viewModel.state.value
    val darkTheme = isSystemInDarkTheme()

    val focusRequester = FocusRequester()

    val icon = if (state.passwordVisibility){
        Icons.Default.VisibilityOff
    }else{
        Icons.Default.Visibility
    }
    val visibility =  if (state.passwordVisibility){
        VisualTransformation.None
    }else{
        PasswordVisualTransformation()
    }



    val scope = rememberCoroutineScope()
    val snackBarManager = SnackBarManager(scope)
    val scaffoldState = rememberScaffoldState()
    var message:String? = null

    LaunchedEffect(key1 = true){
        message = snackBarManager.getScope().launch {
            viewModel.eventFlow.collectLatest {event->
                when(event) {
                    is VendorAuthViewModel.VendorsUiEvent.ShowSnackBar -> {
                        snackBarManager.showSnackBar(
                            scaffoldState = scaffoldState,
                            message = event.message,
                            actionLevel = "DISMISS"
                        )
                    }
                }
            }
        }.toString()
    }

    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (state.isLogin && !state.isPassword) {
                VendorLoginScreen(
                    number = viewModel.loginNumber.value,
                    password = viewModel.loginPassword.value,
                    onNumberChanged = {viewModel.onUiEvent(VendorUiEvent.EnterLoginNumber(it))},
                    onPasswordChanged = {viewModel.onUiEvent(VendorUiEvent.EnterLoginPassword(it))},
                    darkTheme = darkTheme,
                    icon = icon,
                    visibility = visibility,
                    togglePassword = { viewModel.onUiEvent(VendorUiEvent.TogglePasswordVisibilityLogin) },
                    onRegisterClick = { viewModel.onUiEvent(VendorUiEvent.RegisterClick) },
                    onPasswordClick = { viewModel.onUiEvent(VendorUiEvent.PasswordClick) },
                    isBtnLoading = state.isLoginBtnLoading,
                    onSubmitClick = {
                        viewModel.onUiEvent(VendorUiEvent.Login)
                        message
                    }
                )
            }
            if (state.isPassword) {
                VendorPasswordScreen(
                    darkTheme = darkTheme,
                    number = viewModel.forgotNumber.value,
                    password = viewModel.forgotPassword.value,
                    cnfPassword = viewModel.forgotCnfPassword.value,
                    onNumberChanged = {viewModel.onUiEvent(VendorUiEvent.EnterForgotNumber(it))},
                    onPasswordChanged = {viewModel.onUiEvent(VendorUiEvent.EnterForgotPassword(it))},
                    onCnfPasswordChanged = {viewModel.onUiEvent(VendorUiEvent.EnterForgotCnfPassword(it))},
                    onVerifyNumber = {
                        viewModel.onUiEvent(VendorUiEvent.VerifyNumberUpdatePassword)
                        message
                    },
                    icon = icon,
                    visibility = visibility,
                    togglePassword = { viewModel.onUiEvent(VendorUiEvent.ToggleNewPasswordVisibility)},
                    onLoginClick = { viewModel.onUiEvent(VendorUiEvent.LoginTextClickPassword) },
                    onSubmitClick = {
                        viewModel.onUiEvent(VendorUiEvent.SaveNewPassword)
                        message
                    },
                    isBtnLoading = state.isSubmitBtnLoading,
                    btmEnabled = state.passwordBtnEnabled,
                    isPasswordTextLoading = state.isSubmitTextLoading
                )
            }
            if (!state.isLogin && !state.isPassword) {
                VendorRegisterScreen(
                    darkTheme = darkTheme,
                    number = viewModel.number.value,
                    password = viewModel.password.value,
                    otp = viewModel.otp.value,
                    name = viewModel.name.value,
                    email = viewModel.email.value,
                    focusRequester = focusRequester,
                    onNumberChanged = {viewModel.onUiEvent(VendorUiEvent.EnterNumber(it))},
                    onNameChanged = {viewModel.onUiEvent(VendorUiEvent.EnterName(it))},
                    onEmailChanged ={viewModel.onUiEvent(VendorUiEvent.EnterEmail(it))} ,
                    onPasswordChanged = {viewModel.onUiEvent(VendorUiEvent.EnterPassword(it))},
                    onOTPNumberChanged = {viewModel.onUiEvent(VendorUiEvent.EnterOTP(it))},
                    list = Commons.getRadioButtons(),
                    selectedOption = viewModel.vendorType.value,
                    onOptionSelected ={
                        viewModel.onUiEvent(VendorUiEvent.EnterVendorType(it))
                    },
                    icon = icon,
                    visibility = visibility,
                    togglePassword = { viewModel.onUiEvent(VendorUiEvent.ToggleNewPasswordVisibility) },
                    onLoginClick = { viewModel.onUiEvent(VendorUiEvent.LoginTextClickRegister)},
                    onSubmitClick = {
                        viewModel.onUiEvent(VendorUiEvent.RegisterNewVendor)
                        message
                    },
                    btmEnabled = state.registerBtnEnabled,
                    isBtnLoading = state.isRegisterBtnLoading,
                    isRegisterTextLoading = state.isRegisterTextLoading,
                    verifyOTP = {
                        viewModel.onUiEvent(VendorUiEvent.RegisterPasswordVerifyOTP)
                        message
                    },
                    getOTP = {
                        viewModel.onUiEvent(VendorUiEvent.RegisterPasswordGetOTP)
                        message
                    }
                )
            }


        }
    }

}