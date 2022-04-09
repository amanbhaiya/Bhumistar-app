package com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.user_viewmodel


import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.digitalamanmedia.bhumistar.core.Commons.Companion.ALREADY_LOGIN_USER
import com.digitalamanmedia.bhumistar.core.Commons.Companion.FAILED_OTP
import com.digitalamanmedia.bhumistar.core.Commons.Companion.FULL_OTP

import com.digitalamanmedia.bhumistar.core.Commons.Companion.SUCCESS_OTP
import com.digitalamanmedia.bhumistar.core.Commons.Companion.VALID_PASSWORD
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.local.dataModal.UserData
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.CheckEmailDto
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.CreateUserDto
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.LoginUserDto
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.UpdatePasswordDto
import com.digitalamanmedia.bhumistar.data.remote.dto.otpDto.OtpDto
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random


@HiltViewModel
class UserAuthViewModel @Inject constructor (
    private val allUseCases: AllUseCases,
    private val context: Application
): ViewModel(){

    private val _userState = mutableStateOf(UserAuthState())
    val state: State<UserAuthState> = _userState

    private val _id = mutableStateOf(0)
    val id: State<Int> = _id

    // for user login
    private val _loginEmail = mutableStateOf("")
    val loginEmail: State<String> = _loginEmail

    private val _loginPassword = mutableStateOf("")
    val loginPassword: State<String> = _loginPassword

    // for user password update
    private val _forgotEmail = mutableStateOf("")
    val forgotEmail: State<String> = _forgotEmail

    private val _forgotPassword = mutableStateOf("")
    val forgotPassword: State<String> = _forgotPassword

    private val _forgotCnfPassword = mutableStateOf("")
    val forgotCnfPassword: State<String> = _forgotCnfPassword


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

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()



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
            is UserUiEvent.EnterForgotEmail->{
                _forgotEmail.value = event.forgotEmail
            }
            is UserUiEvent.EnterForgotCnfPassword->{
                _forgotCnfPassword.value = event.forgotCnfPassword
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
                viewModelScope.launch {
                    if (userOtp.value.length == 6){
                        if(userOtp.value == otp){
                            _userState.value = state.value.copy(
                                registerBtnEnabled = true
                            )
                            _eventFlow.emit(UiEvent.ShowSnackBar(SUCCESS_OTP))
                        }else{
                            _eventFlow.emit(UiEvent.ShowSnackBar(FAILED_OTP))
                        }
                    }else{
                        _eventFlow.emit(UiEvent.ShowSnackBar(FULL_OTP))
                    }
                }
            }

            is UserUiEvent.RegisterUser->{
                getResponseRegisterUser(
                    name = name.value,
                    number = number.value,
                    email = email.value,
                    password = password.value,
                    navControllerRoot = event.navControllerRoot,
                    from = event.from
                )
            }
            is UserUiEvent.LoginUser->{
                getResponseLoginUser(
                    email = loginEmail.value,
                    password = loginPassword.value,
                    navControllerRoot = event.navControllerRoot,
                    from = event.from
                )
            }
            is UserUiEvent.SavePassword->{
                viewModelScope.launch {
                    if (forgotCnfPassword.value == forgotPassword.value) {
                        getResponseUpdatePassword(
                            email = forgotEmail.value,
                            password = forgotCnfPassword.value
                        )
                    } else {
                        _eventFlow.emit(UiEvent.ShowSnackBar(VALID_PASSWORD))
                    }
                }
            }
            is UserUiEvent.ForgotCheckEmail->{
                getResponseCheckEmail(
                    email = forgotEmail.value
                )
            }
            is UserUiEvent.ForgotTextClick->{
                _userState.value = state.value.copy(
                    isPassword = true
                )
            }
            is UserUiEvent.LoginTextClick->{
                _userState.value = state.value.copy(
                    isLogin = true,
                    isPassword = false
                )
            }
            is UserUiEvent.RegisterTextClick->{
                _userState.value = state.value.copy(
                    isLogin = false
                )
            }
            is UserUiEvent.TogglePasswordVisibility->{
                _userState.value = state.value.copy(
                   passwordVisibility = !state.value.passwordVisibility
                )
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

                is Resource.Loading->{
                    _userState.value = state.value.copy(
                        isRegisterTextLoading = true
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(UiEvent.ShowSnackBar(result.data.message))
                    _userState.value = state.value.copy(
                        isRegisterTextLoading = false
                    )
                }
                is Resource.Error->{
                    _eventFlow.emit(UiEvent.ShowSnackBar(result.message))
                    _userState.value = state.value.copy(
                        isRegisterTextLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseRegisterUser(number:String, name:String,email:String, password:String,navControllerRoot: NavController,from: Int){
        allUseCases.createUserUseCase(
            createUserDto = CreateUserDto(
                number = number,
                name = name,
                email = email,
                password = password
            )
        ).onEach { result->
            when(result){

                is Resource.Loading->{
                    _userState.value = state.value.copy(
                        isRegisterBtnLoading = true
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(UiEvent.ShowSnackBar(result.data.message))
                    _userState.value = state.value.copy(
                        isRegisterBtnLoading = false
                    )
                    if (result.data.status == 1){
                        allUseCases.saveUserDataUseCase(
                            UserData(
                                id = 0,
                                district = null,
                                number = number,
                                name = name,
                                email = email,
                                state = null,
                                pin_code = null,
                            )
                        )
                        allUseCases.verificationAlreadyLoginUseCase.createUserKey(value = ALREADY_LOGIN_USER)
                        if (from != 0){
                            navControllerRoot.popBackStack()
                            navControllerRoot.navigate(Screens.DetailScreen.route+"?id=$from")
                        }else {
                            navControllerRoot.popBackStack()
                        }
                    }
                }
                is Resource.Error->{
                    _eventFlow.emit(UiEvent.ShowSnackBar(result.message))
                    _userState.value = state.value.copy(
                        isRegisterBtnLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseLoginUser(email:String, password: String,navControllerRoot: NavController,from:Int){
        allUseCases.loginUserUseCase(
           loginUserDto = LoginUserDto(
               email = email,
               password = password
           )
        ).onEach { result->
            when(result){

                is Resource.Loading->{
                    _userState.value = state.value.copy(
                        isLoginBtnLoading = true,
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(UiEvent.ShowSnackBar(result.data.message))

                    _userState.value = state.value.copy(
                        isLoginBtnLoading = false
                    )
                    if (result.data.status == 1){
                        allUseCases.saveUserDataUseCase(
                            UserData(
                                id = result.data.data?.id,
                                district = result.data.data?.district,
                                number = result.data.data?.number,
                                name = result.data.data?.name,
                                email = result.data.data?.email,
                                state = result.data.data?.state,
                                pin_code = result.data.data?.pin_code,
                            )
                        )
                        allUseCases.verificationAlreadyLoginUseCase.createUserKey(value = ALREADY_LOGIN_USER)
                        if (from != 0){
                            navControllerRoot.popBackStack()
                            navControllerRoot.navigate(Screens.DetailScreen.route+"?id=$from")
                        }else {
                            navControllerRoot.popBackStack()
                        }
                    }
                }
                is Resource.Error->{
                    _eventFlow.emit(UiEvent.ShowSnackBar(result.message))
                    _userState.value = state.value.copy(
                        isLoginBtnLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseUpdatePassword(email:String, password: String){
        allUseCases.updatePasswordUseCase(
            updatePasswordDto = UpdatePasswordDto(
                email = email,
                password = password
            )
        ).onEach { result->
            when(result){

                is Resource.Loading->{
                    _userState.value = state.value.copy(
                        isSubmitBtnLoading = true
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(UiEvent.ShowSnackBar(result.data.message))
                    _userState.value = state.value.copy(
                        isSubmitBtnLoading = false
                    )
                }
                is Resource.Error->{
                    _eventFlow.emit(UiEvent.ShowSnackBar(result.message))
                    _userState.value = state.value.copy(
                        isSubmitBtnLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseCheckEmail(email:String){
            allUseCases.checkEmailUseCase(
                checkEmailDto = CheckEmailDto(
                    email = email
                )
            ).onEach { result ->
                when (result) {

                    is Resource.Loading -> {
                        _userState.value = state.value.copy(
                            isSubmitTextLoading = true
                        )
                    }
                    is Resource.Success -> {
                        _eventFlow.emit(UiEvent.ShowSnackBar(result.data.message))
                        if (result.data.status == 1) {
                            _userState.value = state.value.copy(
                                passwordBtnEnabled = true
                            )
                        }
                        _userState.value = state.value.copy(
                            isSubmitTextLoading = false
                        )
                    }
                    is Resource.Error -> {
                        _eventFlow.emit(UiEvent.ShowSnackBar(result.message))
                        _userState.value = state.value.copy(
                            isSubmitTextLoading = false,
                            passwordBtnEnabled = true
                        )
                    }
                }
            }.launchIn(viewModelScope)

    }
    sealed class UiEvent{
        data class ShowSnackBar(val message: String): UiEvent()
    }

}