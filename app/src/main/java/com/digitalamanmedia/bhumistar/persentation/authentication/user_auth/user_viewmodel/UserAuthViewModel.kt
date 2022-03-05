package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.authentication.Authentication
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserAuthViewModel @Inject constructor (
    private val allUseCases: AllUseCases
): ViewModel(){

    private val _userState = mutableStateOf(UserAuthState())
    val state: State<UserAuthState> = _userState



    fun onUiEvent(event: UserUiEvent){
        when(event){
            is UserUiEvent.EnterOTP->{
                _userState.value = state.value.copy(
                    number_OTP = event.OTP
                )
            }
            is UserUiEvent.EnterPhoneNumber->{
                _userState.value = state.value.copy(
                    phone_number = event.number
                )
            }
            is UserUiEvent.GetOTP->{
                viewModelScope.launch {
                    allUseCases.sendOTPUseCase(number = event.getOTPNumber)
                }

            }
            is UserUiEvent.VerifyOTP->{
                viewModelScope.launch {
                    allUseCases.verifyOTPUseCase(otp = state.value.number_OTP)
                }

            }
            is UserUiEvent.SaveUser->{

            }
        }
    }
}