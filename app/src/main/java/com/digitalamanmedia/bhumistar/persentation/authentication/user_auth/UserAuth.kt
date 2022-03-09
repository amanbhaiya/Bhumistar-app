package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth

import androidx.compose.foundation.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_auth_screens.ForgotPasswordScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_auth_screens.LoginScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_auth_screens.UserRegisterScreen
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel.UserAuthViewModel
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel.UserUiEvent


@Composable
fun UserAuth(
    onSubmitClick:()->Unit,
    viewModel:UserAuthViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    var isLogin by remember {
        mutableStateOf(true)
    }
    var isPassword by remember {
        mutableStateOf(false)
    }
    val focusRequester = FocusRequester()

    //forgot

    var forgotNumber by remember {
        mutableStateOf("")
    }
    var forgotPassword by remember {
        mutableStateOf("")
    }
    var forgotOtp by remember {
        mutableStateOf("")
    }

    //login
    var loginEmail by remember {
        mutableStateOf("")
    }
    var loginPassword by remember {
        mutableStateOf("")
    }


    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    val darkTheme = isSystemInDarkTheme()
    val icon = if (passwordVisibility){
        Icons.Default.VisibilityOff
    }else{
        Icons.Default.Visibility
    }
    val visibility =  if (passwordVisibility){
        VisualTransformation.None
    }else{
        PasswordVisualTransformation()
    }
    if (isLogin && !isPassword){
        LoginScreen(
            darkTheme = darkTheme,
            email = loginEmail,
            password = loginPassword,
            onEmailChanged = {
                loginEmail = it
            },
            onPasswordChanged = {
                loginPassword = it
            },
            onSubmitClick = {

            },
            onLoginPasswordVisibilityClick = {
                passwordVisibility = !passwordVisibility
            },
            onForgotTextClick =
            {
                isPassword = true
                isLogin = false
            },
            onRegisterTextClick =
            {
                isLogin = false
            },
            icon = icon,
            visibility = visibility
        )
    }
    if (isPassword){
        ForgotPasswordScreen(
            darkTheme = darkTheme,
            number = forgotNumber,
            password = forgotPassword,
            otp = forgotOtp,
            focusRequester = focusRequester,
            onNumberChanged = {
                forgotNumber = it
            },
            onPasswordChanged = {
                forgotPassword = it
            },
            onSubmitClick = { /*TODO*/ },
            onVerifyClick = { /*TODO*/ },
            onForgotPasswordVisibilityClick = {
                passwordVisibility = !passwordVisibility
            },
            onLoginTextClick = {
                isPassword = false
            },
            onOTPNumberChanged = {
                forgotOtp = it
            },
            icon = icon,
            visibility = visibility
        )
    }
    if (!isLogin && !isPassword){
        UserRegisterScreen(
            darkTheme = darkTheme,
            number = viewModel.number.value,
            password = viewModel.password.value,
            otp = viewModel.userOtp.value ,
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
                viewModel.onUiEvent(UserUiEvent.RegisterUser)
            },
            onLoginPasswordVisibilityClick = {
                passwordVisibility = !passwordVisibility
            },
            onLoginTextClick = {
                isLogin = true
            },
            onVerifyClick = {
                viewModel.onUiEvent(UserUiEvent.VerifyOTP)
            },
            onVerifyClickGetOTP = {
                viewModel.onUiEvent(UserUiEvent.GetOTP)
            },
            onOTPNumberChanged = {
                viewModel.onUiEvent(UserUiEvent.EnterPassword(it))
            },
            icon = icon,
            visibility = visibility
        )
    }



}