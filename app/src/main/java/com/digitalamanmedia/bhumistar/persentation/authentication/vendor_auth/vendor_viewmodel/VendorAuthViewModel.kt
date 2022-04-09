package com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.vendor_viewmodel


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.digitalamanmedia.bhumistar.core.Commons.Companion.ALREADY_LOGIN_VENDOR
import com.digitalamanmedia.bhumistar.core.Commons.Companion.FAILED_OTP
import com.digitalamanmedia.bhumistar.core.Commons.Companion.FULL_OTP
import com.digitalamanmedia.bhumistar.core.Commons.Companion.SUCCESS_OTP
import com.digitalamanmedia.bhumistar.core.Commons.Companion.VALID_PASSWORD
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.local.dataModal.VendorData
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.CreateVendorDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.LoginVendorDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.VendorNumberDto
import com.digitalamanmedia.bhumistar.data.remote.dto.VendorDto.VendorPasswordUpdateDto
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
class VendorAuthViewModel @Inject constructor(
    private val allUseCases: AllUseCases
):ViewModel(){

    //login
    private val _loginNumber = mutableStateOf("")
    val loginNumber : State<String> = _loginNumber

    private val _loginPassword = mutableStateOf("")
    val loginPassword: State<String> = _loginPassword

    //forgot password
    private val _forgotNumber = mutableStateOf("")
    val forgotNumber: State<String> = _forgotNumber

    private val _forgotPassword = mutableStateOf("")
    val forgotPassword: State<String> = _forgotPassword

    private val _forgotCnfPassword = mutableStateOf("")
    val forgotCnfPassword: State<String> = _forgotCnfPassword

    //register

    private val _vendorType = mutableStateOf("")
    val vendorType: State<String> = _vendorType
    
    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _number = mutableStateOf("")
    val number: State<String> = _number

    private val _otp = mutableStateOf("")
    val otp: State<String> = _otp

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _state = mutableStateOf(VendorAuthState())
    val state: State<VendorAuthState> = _state
    
    private val _eventFlow = MutableSharedFlow<VendorsUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val random = Random.nextInt(111111,999999)
    private val otpSend:String = random.toString()


    fun onUiEvent(event: VendorUiEvent){
        when(event){

            // Vendor Login UiEvent
            is VendorUiEvent.EnterLoginNumber->{
                _loginNumber.value = event.loginEmail
            }
            is VendorUiEvent.EnterLoginPassword->{
                _loginPassword.value = event.loginPassword
            }
            is VendorUiEvent.Login->{
                getResponseLogin(
                    number = loginNumber.value,
                    password = loginPassword.value,
                    navControllerRoot = event.navControllerRoot,
                    from = event.from
                )
            }
            is VendorUiEvent.TogglePasswordVisibilityLogin->{
                _state.value = state.value.copy(
                    passwordVisibility = !state.value.passwordVisibility
                )
            }
            is VendorUiEvent.RegisterClick->{
                _state.value = state.value.copy(
                    isLogin = false
                )
            }
            is VendorUiEvent.PasswordClick->{
                _state.value = state.value.copy(
                    isPassword = true
                )
            }

            //Forgot Password UiEvent
            is VendorUiEvent.EnterForgotNumber->{
                _forgotNumber.value = event.forgotNumber
            }
            is VendorUiEvent.EnterForgotPassword->{
                _forgotPassword.value = event.forgotPassword
            }
            is VendorUiEvent.EnterForgotCnfPassword->{
                _forgotCnfPassword.value = event.forgotCnfPassword
            }
            is VendorUiEvent.SaveNewPassword->{
                viewModelScope.launch {
                    if (forgotCnfPassword.value == forgotPassword.value) {
                        getResponseUpdatePassword(
                            number = forgotNumber.value,
                            password = forgotCnfPassword.value
                        )
                    } else {
                        _eventFlow.emit(VendorsUiEvent.ShowSnackBar(VALID_PASSWORD))
                    }
                }
            }
            is VendorUiEvent.ToggleNewPasswordVisibility->{
                _state.value = state.value.copy(
                    passwordVisibility = !state.value.passwordVisibility
                )
            }
            is VendorUiEvent.VerifyNumberUpdatePassword->{
                getResponseCheckPhoneNumber(
                    number = forgotNumber.value
                )
            }
            is VendorUiEvent.LoginTextClickPassword->{
                _state.value = state.value.copy(
                    isPassword = false
                )
            }

            // New Vendor Registration UiEvent
            is VendorUiEvent.EnterName->{
                _name.value = event.name
            }
            is VendorUiEvent.EnterNumber->{
                _number.value = event.number
            }
            is VendorUiEvent.EnterEmail->{
                _email.value = event.email
            }
            is VendorUiEvent.EnterPassword->{
                _password.value = event.password
            }
            is VendorUiEvent.EnterOTP->{
                _otp.value = event.OTP
            }
            is VendorUiEvent.EnterVendorType->{
                _vendorType.value = event.vendorType
            }
            is VendorUiEvent.RegisterNewVendor->{
                getResponseToRegister(
                    type = vendorType.value,
                    name = name.value,
                    email = email.value,
                    number = number.value,
                    password = password.value,
                    navControllerRoot = event.navControllerRoot,
                    from = event.from
                )
            }
            is VendorUiEvent.RegisterPasswordGetOTP->{
                getResponseToSendOtp(
                    number = number.value,
                    message = state.value.message+otpSend
                )
            }
            is VendorUiEvent.RegisterPasswordVerifyOTP->{
                viewModelScope.launch {
                    if (otp.value.length == 6){
                        if(otp.value == otpSend){
                            _state.value = state.value.copy(
                                registerBtnEnabled = true
                            )
                            _eventFlow.emit(VendorsUiEvent.ShowSnackBar(SUCCESS_OTP))
                        }else{
                            _eventFlow.emit(VendorsUiEvent.ShowSnackBar(FAILED_OTP))
                        }
                    }else{
                        _eventFlow.emit(VendorsUiEvent.ShowSnackBar(FULL_OTP))
                    }
                }
            }
            is VendorUiEvent.ToggleRegisterPasswordVisibility->{
                _state.value = state.value.copy(
                    passwordVisibility = !state.value.passwordVisibility
                )
            }
            is VendorUiEvent.LoginTextClickRegister->{
                _state.value = state.value.copy(
                    isLogin = true
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
                    _state.value = state.value.copy(
                        isRegisterTextLoading = true
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(VendorsUiEvent.ShowSnackBar(result.data.message))
                    _state.value = state.value.copy(
                        isRegisterTextLoading = false
                    )
                }
                is Resource.Error->{
                    _eventFlow.emit(VendorsUiEvent.ShowSnackBar(result.message))
                    _state.value = state.value.copy(
                        isRegisterTextLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }


    private fun getResponseToRegister(
        type:String,
        name:String,
        email:String,
        password: String,
        number:String,
        navControllerRoot: NavController,
        from:Int
    ){
        allUseCases.createVendorUseCase(
            createVendorDto = CreateVendorDto(
                vendor_type = type,
                vendor_name = name,
                vendor_email = email,
                vendor_ph_number = number,
                vendor_password = password
            )
        ).onEach { result->
            when(result){

                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isRegisterBtnLoading = true
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(VendorsUiEvent.ShowSnackBar(result.data.message))
                    _state.value = state.value.copy(
                        isRegisterBtnLoading = false
                    )
                    if (result.data.status == 1) {
                        if (from == 1){
                            navControllerRoot.popBackStack()
                            navControllerRoot.navigate(Screens.ListProperty.route)
                        }else {
                            navControllerRoot.popBackStack()
                        }
                    }
                }
                is Resource.Error->{
                    _eventFlow.emit(VendorsUiEvent.ShowSnackBar(result.message))
                    _state.value = state.value.copy(
                        isRegisterBtnLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseLogin(number:String, password:String,navControllerRoot: NavController,from: Int){
        allUseCases.loginVendorUseCase(
            loginVendorDto = LoginVendorDto(
                vendor_password = password,
                vendor_ph_number = number
            )
        ).onEach { result->
            when(result){

                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isLoginBtnLoading = true
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(VendorsUiEvent.ShowSnackBar(result.data.message))
                    _state.value = state.value.copy(
                        isLoginBtnLoading = false
                    )
                    if (result.data.status == 1){
                        allUseCases.saveVendorDataUseCase(
                            vendorData = VendorData(
                                name = result.data.data?.vendor_name,
                                number = result.data.data?.vendor_phone,
                                email = result.data.data?.vendor_email,
                                vendorType = result.data.data?.vendor_type,
                                vendor_id = result.data.data?.id
                            )
                        )
                        allUseCases.vendorVerificationAlreadyLoginUseCase.createVendorKey(
                            ALREADY_LOGIN_VENDOR
                        )
                        _state.value = state.value.copy(
                            registerBtnEnabled = true
                        )
                        if (from == 1){
                            navControllerRoot.popBackStack()

                            navControllerRoot.navigate(Screens.ListProperty.route)
                        }else {
                            navControllerRoot.popBackStack()
                        }
                    }
                }
                is Resource.Error->{
                    _eventFlow.emit(VendorsUiEvent.ShowSnackBar(result.message))
                    _state.value = state.value.copy(
                        isLoginBtnLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseCheckPhoneNumber(number:String){
        allUseCases.vendorNumberCheckUseCase(
            vendorNumberDto = VendorNumberDto(
                vendor_ph_number = number
            )
        ).onEach { result->
            when(result){

                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isSubmitTextLoading = true
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(VendorsUiEvent.ShowSnackBar(result.data.message))
                    _state.value = state.value.copy(
                        isSubmitTextLoading = false
                    )
                    if (result.data.status == 1){
                        _state.value = state.value.copy(
                            passwordBtnEnabled = true
                        )
                    }
                }
                is Resource.Error->{
                    _eventFlow.emit(VendorsUiEvent.ShowSnackBar(result.message))
                    _state.value = state.value.copy(
                        isSubmitTextLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    private fun getResponseUpdatePassword(number:String, password:String){
        allUseCases.vendorPasswordUpdateUseCase(
            vendorPasswordUpdateDto = VendorPasswordUpdateDto(
                vendor_ph_number = number,
                vendor_password = password
            )
        ).onEach { result->
            when(result){

                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isSubmitBtnLoading = true
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(VendorsUiEvent.ShowSnackBar(result.data.message))
                    _state.value = state.value.copy(
                        isSubmitBtnLoading = false
                    )
                }
                is Resource.Error->{
                    _eventFlow.emit(VendorsUiEvent.ShowSnackBar(result.message))
                    _state.value = state.value.copy(
                        isSubmitBtnLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }


    sealed class VendorsUiEvent{
        data class ShowSnackBar(val message: String): VendorsUiEvent()
    }
}