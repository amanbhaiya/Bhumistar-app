package com.digitalamanmedia.bhumistar.persentation.screens.profile.view_model

import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalamanmedia.bhumistar.core.Commons.Companion.ALREADY_LOGIN_USER
import com.digitalamanmedia.bhumistar.core.Commons.Companion.LOGO
import com.digitalamanmedia.bhumistar.core.Commons.Companion.VALID_PASSWORD
import com.digitalamanmedia.bhumistar.core.utils.EncodedImages
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.local.dataModal.UserData
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.UpdateUserDto
import com.digitalamanmedia.bhumistar.data.remote.dto.UserDto.UserImageUploadDto
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.authentication.AuthenticationActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModal @Inject constructor(
    private val allUseCases: AllUseCases,
    private val context: Application
):ViewModel(){


    private val _name = mutableStateOf("")
    val name: State<String> = _name

    private val _id = mutableStateOf(0)
    val id: State<Int> = _id

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _password = mutableStateOf("")
    val password: State<String> = _password

    private val _cnfPassword = mutableStateOf("")
    val cnfPassword: State<String> = _cnfPassword

    private val _number = mutableStateOf("")
    val number: State<String> = _number

    private val _state = mutableStateOf("")
    val state: State<String> = _state

    private val _city = mutableStateOf("")
    val city: State<String> = _city

    private val _pinCode = mutableStateOf("")
    val pinCode: State<String> = _pinCode


    private val _profileState = mutableStateOf(ProfileUserState())
    val profileState: State<ProfileUserState> = _profileState

    private val _eventFlow = MutableSharedFlow<ProfileUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _userImage = mutableStateOf("")
    private val userImage: State<String> = _userImage

    private val _userName = mutableStateOf("")
    val userName: State<String> = _userName

    private val _userEmail = mutableStateOf("")
    val userEmail: State<String> = _userEmail


    init {
        viewModelScope.launch {
            if (allUseCases.verificationAlreadyLoginUseCase.readUserKey(ALREADY_LOGIN_USER) == ALREADY_LOGIN_USER) {
                allUseCases.readUserDataUseCase().collect{ data->
                    _id.value = data.id?:0
                    _userName.value = data.name?:""
                    _userEmail.value = data.email?:""
                    _number.value = data.number?:""
                    _state.value = data.state?:""
                    _city.value = data.district?:""
                    _pinCode.value = data.pin_code?:""

                    _name.value = userName.value
                    _email.value = userEmail.value
                    _profileState.value = profileState.value.copy(
                        isUserLogin = true
                    )

                    getUserImage(id.value)
                }
            } else {
                _profileState.value = profileState.value.copy(
                    userImageUri = LOGO
                )
            }

        }
    }



    fun onUiEvent(event: ProfileUserUiEvent){
        when(event){
            is ProfileUserUiEvent.GetPictureUri->{
                _profileState.value = profileState.value.copy(
                    profilePicUri = event.uri
                )
                viewModelScope.launch {
                   _userImage.value = EncodedImages.encodedString(
                       uri = profileState.value.profilePicUri,
                       context = context
                   )
                    if (userImage.value.isNotEmpty()) {
                        uploadUserImage()


                    }
                }

            }
            is ProfileUserUiEvent.EnterName->{
                _name.value = event.name
            }
            is ProfileUserUiEvent.EnterNumber->{
                _number.value = event.number
            }
            is ProfileUserUiEvent.EnterEmail->{
                _email.value = event.email
            }
            is ProfileUserUiEvent.EnterState->{
                _state.value = event.state
            }
            is ProfileUserUiEvent.EnterCity->{
                _city.value = event.city
            }
            is ProfileUserUiEvent.EnterPinCode->{
                _pinCode.value = event.pinCode
            }
            is ProfileUserUiEvent.EnterPassword->{
                _password.value = event.password
            }
            is ProfileUserUiEvent.EnterConfirmPassword->{
                _cnfPassword.value = event.cnfPassword
            }
            is ProfileUserUiEvent.OnCityClick->{
                _city.value = ""
                _city.value = event.cities
                _profileState.value = profileState.value.copy(
                    expandedCity = false
                )
            }
            is ProfileUserUiEvent.OnStateClick->{
                if (state.value != event.states){
                    _state.value = ""
                    _state.value = event.states
                    _city.value = ""
                }
                _profileState.value = profileState.value.copy(
                    expandedState = false
                )
            }
            is ProfileUserUiEvent.OnStateDrop->{
                _profileState.value = profileState.value.copy(
                    expandedState = !profileState.value.expandedState
                )
            }
            is ProfileUserUiEvent.OnCityDrop->{
                _profileState.value = profileState.value.copy(
                    expandedCity = !profileState.value.expandedCity
                )
            }
            is ProfileUserUiEvent.OnNameClear->{
                _name.value = ""
            }
            is ProfileUserUiEvent.OnNumberClear->{
                _number.value = ""
            }
            is ProfileUserUiEvent.OnEmailClear->{
                _email.value = ""
            }
            is ProfileUserUiEvent.OnPinCodeClear->{
                _pinCode.value = ""
            }
            is ProfileUserUiEvent.UpdateUser->{
                viewModelScope.launch {
                    if (password.value == cnfPassword.value){
                        getResponseUpdateUser(
                            name = name.value,
                            number = number.value,
                            email = email.value,
                            pinCode = pinCode.value,
                            state = state.value,
                            city = city.value,
                            password = password.value,
                            id = id.value
                        )
                    }else{
//                      _eventFlow.emit(ProfileUiEvent.ShowSnackBar(VALID_PASSWORD))
                      Toast.makeText(context.applicationContext, VALID_PASSWORD,Toast.LENGTH_LONG).show()
                    }
              }
            }
            is ProfileUserUiEvent.ToggleCnfPassword->{
                _profileState.value = profileState.value.copy(
                    passwordVisibilityCnf = !profileState.value.passwordVisibilityCnf
                )
            }
            is ProfileUserUiEvent.TogglePassword->{
                _profileState.value = profileState.value.copy(
                    passwordVisibility = !profileState.value.passwordVisibility
                )
            }
            is ProfileUserUiEvent.OnEditClick->{
                _profileState.value = profileState.value.copy(
                    isEnable = true,
                    isReadable = false,
                    trailingEnabled = true
                )
            }
            is ProfileUserUiEvent.UserLogin->{
                val i = Intent(context, AuthenticationActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                context.startActivity(i)
            }
            is ProfileUserUiEvent.TermsIsVisible->{
                _profileState.value = profileState.value.copy(
                    isTerms = true
                )
            }
            is ProfileUserUiEvent.PrivacyIsVisible->{
                _profileState.value = profileState.value.copy(
                    isPrivacy = true
                )
            }
            is ProfileUserUiEvent.TermsIsBack->{
                _profileState.value = profileState.value.copy(
                    isTerms = false
                )
            }
            is ProfileUserUiEvent.PrivacyIsBack->{
                _profileState.value = profileState.value.copy(
                    isPrivacy = false
                )
            }
        }
    }

    private fun getResponseUpdateUser(
        number:String,
        name:String,
        email:String,
        password:String,
        state:String,
        city:String,
        pinCode:String,
        id:Int
    ){
        allUseCases.updateUserUseCase(
            updateUserDto = UpdateUserDto(
                number = number,
                name = name,
                email = email,
                password = password,
                state = state,
                district = city,
                pin_code = pinCode
            )
        ).onEach { result->
            when(result){

                is Resource.Loading->{
                    _profileState.value = profileState.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(ProfileUiEvent.ShowSnackBar(result.data.message))
                    Toast.makeText(context.applicationContext, result.data.message,Toast.LENGTH_LONG).show()
                    _profileState.value = profileState.value.copy(
                        isLoading = false
                    )
                    if (result.data.status == 1){
                        allUseCases.saveUserDataUseCase(
                            UserData(
                                id = id,
                                district = state,
                                number = number,
                                name = name,
                                email = email,
                                state = state,
                                pin_code = pinCode,
                            )
                        )
                        _profileState.value = profileState.value.copy(
                            isEnable = false,
                            isReadable = true
                        )
                    }
                }
                is Resource.Error->{
                    _eventFlow.emit(ProfileUiEvent.ShowSnackBar(result.message))
                    Toast.makeText(context.applicationContext, result.message,Toast.LENGTH_LONG).show()
                    _profileState.value = profileState.value.copy(
                        isLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getUserImage(id: Int){
        allUseCases.readUserImageUseCase(id).onEach { result->
            when(result){
                is Resource.Loading->{
                    _profileState.value = profileState.value.copy(
                        isImageLoading = true
                    )
                }
                is Resource.Success->{
                    if (result.data.status == 1){
                        _profileState.value = profileState.value.copy(
                            userImageUri = result.data.image?: LOGO,
                            isImageLoading = false
                        )
                    }
                }
                is Resource.Error->{
                    _profileState.value = profileState.value.copy(
                        isImageLoading = false
                    )
                    Toast.makeText(context.applicationContext,result.message,Toast.LENGTH_LONG).show()
                }
            }

        }.launchIn(viewModelScope)
    }
    private fun uploadUserImage(){
        allUseCases.uploadImageUseCase(
            UserImageUploadDto(
                id = id.value,
                userImage = userImage.value
            )
        ).onEach { result->
            when(result){
                is Resource.Loading->{}
                is Resource.Success->{
                    if (result.data.status == 1){
                        getUserImage(id.value)
                        Toast.makeText(context.applicationContext,result.data.message,Toast.LENGTH_LONG).show()
                    }
                    Toast.makeText(context.applicationContext,result.data.message,Toast.LENGTH_LONG).show()

                }
                is Resource.Error->{
                    Toast.makeText(context.applicationContext,result.message,Toast.LENGTH_LONG).show()
                }
            }

        }.launchIn(viewModelScope)
    }


    sealed class ProfileUiEvent{
        data class ShowSnackBar(val message: String): ProfileUiEvent()
    }
}