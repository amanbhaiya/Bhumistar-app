package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.navigation.NavController
import com.digitalamanmedia.bhumistar.core.utils.SnackBarManager
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_auth_screens.ForgotPasswordScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_auth_screens.LoginScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_auth_screens.UserRegisterScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel.UserAuthViewModel
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel.UserUiEvent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun UserAuth(
    viewModel:UserAuthViewModel = hiltViewModel(),
    navControllerRoot:NavController,
    from:Int
) {
    val scope = rememberCoroutineScope()
    val snackBarManager = SnackBarManager(scope)
    val scaffoldState = rememberScaffoldState()
    var message:String? = null

    LaunchedEffect(key1 = true){
        message = snackBarManager.getScope().launch {
            viewModel.eventFlow.collectLatest {event->
                when(event) {
                    is UserAuthViewModel.UiEvent.ShowSnackBar -> {
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

    val state = viewModel.state.value

    val focusRequester = FocusRequester()

    val darkTheme = isSystemInDarkTheme()
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

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (state.isLogin && !state.isPassword) {
                LoginScreen(
                    darkTheme = darkTheme,
                    email = viewModel.loginEmail.value,
                    password = viewModel.loginPassword.value,
                    onEmailChanged = {
                        viewModel.onUiEvent(UserUiEvent.EnterLoginEmail(it))
                    },
                    onPasswordChanged = {
                        viewModel.onUiEvent(UserUiEvent.EnterLoginPassword(it))
                    },
                    onSubmitClick = {
                        viewModel.onUiEvent(UserUiEvent.LoginUser(navControllerRoot,from))
                        message
                    },
                    onLoginPasswordVisibilityClick = {
                        viewModel.onUiEvent(UserUiEvent.TogglePasswordVisibility)
                    },
                    onForgotTextClick =
                    {
                        viewModel.onUiEvent(UserUiEvent.ForgotTextClick)
                    },
                    onRegisterTextClick =
                    {
                        viewModel.onUiEvent(UserUiEvent.RegisterTextClick)
                    },
                    icon = icon,
                    visibility = visibility,
                    btmEnabled = true,
                    isBtnLoading = state.isLoginBtnLoading
                )
            }
            else if (state.isPassword) {
                ForgotPasswordScreen(
                    darkTheme = darkTheme,
                    email = viewModel.forgotEmail.value,
                    password = viewModel.forgotPassword.value,
                    cnfPassword = viewModel.forgotCnfPassword.value,
                    onEmailChanged = {
                        viewModel.onUiEvent(UserUiEvent.EnterForgotEmail(it))
                    },
                    onPasswordChanged = {
                        viewModel.onUiEvent(UserUiEvent.EnterForgotPassword(it))
                    },
                    onSubmitClick = {
                        viewModel.onUiEvent(UserUiEvent.SavePassword)
                        message
                    },
                    onClickVerify = {
                        viewModel.onUiEvent(UserUiEvent.ForgotCheckEmail)
                        message
                    },
                    onForgotPasswordVisibilityClick = {
                        viewModel.onUiEvent(UserUiEvent.TogglePasswordVisibility)
                    },
                    onLoginTextClick = {
                        viewModel.onUiEvent(UserUiEvent.LoginTextClick)
                    },
                    onCnfNumberChanged = {
                        viewModel.onUiEvent(UserUiEvent.EnterForgotCnfPassword(it))
                    },
                    icon = icon,
                    visibility = visibility,
                    btmEnabled = state.passwordBtnEnabled,
                    isTextLoading = state.isSubmitTextLoading,
                    isBtnLoading = state.isSubmitBtnLoading
                )
            }
            else if (!state.isLogin && !state.isPassword) {
                UserRegisterScreen(
                    darkTheme = darkTheme,
                    number = viewModel.number.value,
                    password = viewModel.password.value,
                    otp = viewModel.userOtp.value,
                    name = viewModel.name.value,
                    email = viewModel.email.value,
                    focusRequester = focusRequester,
                    onNumberChanged = {
                        viewModel.onUiEvent(UserUiEvent.EnterNumber(it))
                    },
                    onNameChanged = {
                        viewModel.onUiEvent(UserUiEvent.EnterName(it))
                    },
                    onEmailChanged = {
                        viewModel.onUiEvent(UserUiEvent.EnterEmail(it))
                    },
                    onPasswordChanged = {
                        viewModel.onUiEvent(UserUiEvent.EnterPassword(it))
                    },
                    onSubmitClick = {
                        viewModel.onUiEvent(UserUiEvent.RegisterUser(navControllerRoot,from))
                        message

                    },
                    onLoginPasswordVisibilityClick = {
                        viewModel.onUiEvent(UserUiEvent.TogglePasswordVisibility)
                    },
                    onLoginTextClick = {
                        viewModel.onUiEvent(UserUiEvent.LoginTextClick)
                    },
                    onVerifyClick = {
                        viewModel.onUiEvent(UserUiEvent.VerifyOTP)
                        message
                    },
                    onVerifyClickGetOTP = {
                        viewModel.onUiEvent(UserUiEvent.GetOTP)
                        message
                    },
                    onOTPNumberChanged = {
                        viewModel.onUiEvent(UserUiEvent.EnterOTP(it))
                    },
                    icon = icon,
                    visibility = visibility,
                    btmEnabled = state.registerBtnEnabled,
                    isBtnLoading = state.isRegisterBtnLoading,
                    isTextLoading = state.isRegisterTextLoading
                )
            }
        }
    }
}