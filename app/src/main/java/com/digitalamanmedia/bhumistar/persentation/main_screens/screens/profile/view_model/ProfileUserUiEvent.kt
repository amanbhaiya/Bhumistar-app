package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.profile.view_model

import android.net.Uri
import androidx.navigation.NavController

sealed class ProfileUserUiEvent{
    data class EnterName(val name:String):ProfileUserUiEvent()
    data class EnterNumber(val number:String):ProfileUserUiEvent()
    data class EnterEmail(val email:String):ProfileUserUiEvent()
    data class EnterState(val state:String):ProfileUserUiEvent()
    data class EnterCity(val city:String):ProfileUserUiEvent()
    data class EnterPinCode(val pinCode:String):ProfileUserUiEvent()
    data class EnterPassword(val password:String):ProfileUserUiEvent()
    data class EnterConfirmPassword(val cnfPassword:String):ProfileUserUiEvent()
    data class OnCityClick(val cities:String):ProfileUserUiEvent()
    data class OnStateClick(val states:String):ProfileUserUiEvent()
    data class GetPictureUri(val uri: Uri?):ProfileUserUiEvent()
    object OnStateDrop:ProfileUserUiEvent()
    object OnCityDrop:ProfileUserUiEvent()
    object OnNameClear:ProfileUserUiEvent()
    object OnNumberClear:ProfileUserUiEvent()
    object OnEmailClear:ProfileUserUiEvent()
    object OnPinCodeClear:ProfileUserUiEvent()
    object UpdateUser:ProfileUserUiEvent()
    object TogglePassword:ProfileUserUiEvent()
    object ToggleCnfPassword:ProfileUserUiEvent()
    object OnEditClick:ProfileUserUiEvent()
    data class UserLogin(val navControllerRoot: NavController):ProfileUserUiEvent()
    object TermsIsVisible:ProfileUserUiEvent()
    object PrivacyIsVisible:ProfileUserUiEvent()
    object TermsIsBack:ProfileUserUiEvent()
    object PrivacyIsBack:ProfileUserUiEvent()
}
