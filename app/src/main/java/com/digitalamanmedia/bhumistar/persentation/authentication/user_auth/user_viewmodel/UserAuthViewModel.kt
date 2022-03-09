package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel


import android.app.Application

import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalamanmedia.bhumistar.core.Commons.Companion.FAILED_OTP
import com.digitalamanmedia.bhumistar.core.Commons.Companion.FULL_OTP

import com.digitalamanmedia.bhumistar.core.Commons.Companion.SUCCESS_OTP
import com.digitalamanmedia.bhumistar.core.utils.Resourse
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.CheckPhoneNumberDto
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.CreateUserDto
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.LoginUserDto
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.UpdatePasswordDto
import com.digitalamanmedia.bhumistar.data.remote.dto.otpDto.OtpDto
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.domain.use_cases.authentication.SendOTPUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random


@HiltViewModel
class UserAuthViewModel @Inject constructor (
    private val allUseCases: AllUseCases,
    private val context:Application
): ViewModel(){

    private val _userState = mutableStateOf(UserAuthState())
    val state: State<UserAuthState> = _userState


    // for user login
    private val _loginEmail = mutableStateOf("")
    val loginEmail: State<String> = _loginEmail

    private val _loginPassword = mutableStateOf("")
    val loginPassword: State<String> = _loginPassword

    // for user password update
    private val _forgotNumber = mutableStateOf("")
    val forgotNumber: State<String> = _forgotNumber

    private val _forgotPassword = mutableStateOf("")
    val forgotPassword: State<String> = _forgotPassword

    private val _forgotOtp = mutableStateOf("")
    val forgotOtp: State<String> = _forgotOtp


    // for user registration
    private val _number = mutableStateOf("")
    val number: State<String> = _number

    private val _userOtp = mutableStateOf("")
    val userOtp: State<String> = _userOtp

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _password = mutableStateOf("")
    val password: State<String> = _password


    private val random = Random.nextInt(111111,999999)
    private val otp:String = random.toString()


    fun onUiEvent(event: UserUiEvent){
        when(event){
            is UserUiEvent.EnterNumber->{
                _number.value = event.number
            }
            is UserUiEvent.EnterOTP->{
                _userOtp.value = event.OTP
            }
            is UserUiEvent.EnterName->{
                _name.value = event.name
            }
            is UserUiEvent.EnterEmail->{
                _email.value = event.email
            }
            is UserUiEvent.EnterPassword->{
                _password.value = event.password
            }
            is UserUiEvent.EnterLoginEmail->{
                _loginEmail.value = event.loginEmail
            }
            is UserUiEvent.EnterLoginPassword->{
                _loginPassword.value = event.loginPassword
            }
            is UserUiEvent.EnterForgotNumber->{
                _forgotNumber.value = event.forgotNumber
            }
            is UserUiEvent.EnterForgotOTP->{
                _forgotOtp.value = event.forgotOTP
            }
            is UserUiEvent.EnterForgotPassword->{
                _forgotPassword.value = event.forgotPassword
            }
            is UserUiEvent.GetOTP->{

                getResponseToSendOtp(
                    number = number.value,
                    message = state.value.message+otp
                )
                           }
            is UserUiEvent.VerifyOTP->{

              if (userOtp.value.length == 6){
                  if(userOtp.value == otp){
                      Toast.makeText(context.applicationContext,SUCCESS_OTP,Toast.LENGTH_LONG).show()
                  }else{
                      Toast.makeText(context.applicationContext, FAILED_OTP,Toast.LENGTH_LONG).show()
                  }
              }else{
                  Toast.makeText(context.applicationContext, FULL_OTP,Toast.LENGTH_LONG).show()
              }
            }

            is UserUiEvent.RegisterUser->{
                getResponseRegisterUser(
                    name = name.value,
                    number = number.value,
                    email = email.value,
                    password = password.value
                )
            }
            is UserUiEvent.LoginUser->{

            }
            is UserUiEvent.SavePassword->{

            }
        }
    }
    private fun getResponseToSendOtp(number:String, message:String){
        allUseCases.sendOTPUseCase(
            otpDto = OtpDto(
                number = number,
                message = message
            )
        ).onEach { result->
            when(result){

                is Resourse.Loading->{
                    _userState.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resourse.Success->{
                    Toast.makeText(context.applicationContext, result.data.message,Toast.LENGTH_LONG).show()
                    _userState.value = state.value.copy(
                        isLoading = false
                    )
                }
                is Resourse.Error->{
                    Toast.makeText(context.applicationContext,result.message,Toast.LENGTH_LONG).show()
                    _userState.value = state.value.copy(
                        isLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseRegisterUser(number:String, name:String,email:String, password:String){
        allUseCases.createUserUseCase(
            createUserDto = CreateUserDto(
                number = number,
                name = name,
                email = email,
                password = password
            )
        ).onEach { result->
            when(result){

                is Resourse.Loading->{
                    _userState.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resourse.Success->{
                    Toast.makeText(context.applicationContext, result.data.message,Toast.LENGTH_LONG).show()
                    _userState.value = state.value.copy(
                        isLoading = false
                    )
                }
                is Resourse.Error->{
                    Toast.makeText(context.applicationContext,result.message,Toast.LENGTH_LONG).show()
                    _userState.value = state.value.copy(
                        isLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseLoginUser(email:String, password: String){
        allUseCases.loginUserUseCase(
           loginUserDto = LoginUserDto(
               email = email,
               password = password
           )
        ).onEach { result->
            when(result){

                is Resourse.Loading->{
                    _userState.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resourse.Success->{
                    Toast.makeText(context.applicationContext, result.data.message,Toast.LENGTH_LONG).show()
                    _userState.value = state.value.copy(
                        isLoading = false
                    )
                }
                is Resourse.Error->{
                    Toast.makeText(context.applicationContext,result.message,Toast.LENGTH_LONG).show()
                    _userState.value = state.value.copy(
                        isLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseUpdatePassword(number:String, password: String){
        allUseCases.updatePasswordUseCase(
            updatePasswordDto = UpdatePasswordDto(
                number = number,
                password = password
            )
        ).onEach { result->
            when(result){

                is Resourse.Loading->{
                    _userState.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resourse.Success->{
                    Toast.makeText(context.applicationContext, result.data.message,Toast.LENGTH_LONG).show()
                    _userState.value = state.value.copy(
                        isLoading = false
                    )
                }
                is Resourse.Error->{
                    Toast.makeText(context.applicationContext,result.message,Toast.LENGTH_LONG).show()
                    _userState.value = state.value.copy(
                        isLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseCheckNumber(number:String){
        allUseCases.checkNumberUseCase(
            checkPhoneNumberDto = CheckPhoneNumberDto(
                user_ph_number = number
            )
        ).onEach { result->
            when(result){

                is Resourse.Loading->{
                    _userState.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resourse.Success->{
                    Toast.makeText(context.applicationContext, result.data.message,Toast.LENGTH_LONG).show()
                    _userState.value = state.value.copy(
                        isLoading = false
                    )
                }
                is Resourse.Error->{
                    Toast.makeText(context.applicationContext,result.message,Toast.LENGTH_LONG).show()
                    _userState.value = state.value.copy(
                        isLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}