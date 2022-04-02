package com.digitalamanmedia.bhumistar.persentation.screens.profile.view_model

import android.net.Uri


data class ProfileUserState(
    val isReadable:Boolean = true,
    val isEnable:Boolean = false,
    val expandedState:Boolean = false,
    val expandedCity:Boolean = false,
    val passwordVisibility:Boolean = false,
    val passwordVisibilityCnf:Boolean = false,
    val trailingEnabled:Boolean = false,
    val isLoading:Boolean = false,
    val isImageLoading:Boolean = false,
    val isTerms:Boolean = false,
    val isPrivacy:Boolean = false,
    val userImageUri:String = "",
    val profilePicUri: Uri? = null,
    val isUserLogin:Boolean = false
)
