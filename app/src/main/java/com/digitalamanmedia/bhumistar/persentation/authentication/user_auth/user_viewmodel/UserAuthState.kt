package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel


import com.digitalamanmedia.bhumistar.core.Commons.Companion.MESSAGE

data class UserAuthState(
    val registerBtnEnabled: Boolean = false,
    val passwordBtnEnabled: Boolean = false,
    val message:String = MESSAGE,
    val passwordVisibility: Boolean = false,
    val isPassword:Boolean = false,
    val isLogin:Boolean = true,
    val isSubmitBtnLoading: Boolean = false,
    val isRegisterBtnLoading:Boolean = false,
    val isLoginBtnLoading:Boolean = false,
    val isSubmitTextLoading:Boolean = false,
    val isRegisterTextLoading:Boolean = false,
)