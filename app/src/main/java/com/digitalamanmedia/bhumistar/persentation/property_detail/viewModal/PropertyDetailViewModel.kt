package com.digitalamanmedia.bhumistar.persentation.property_detail.viewModal

import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.remote.dto.PropertyDto.PostCommentDto
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.authentication.AuthenticationActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PropertyDetailViewModel @Inject constructor(
    private val allUseCases: AllUseCases,
    savedStateHandle: SavedStateHandle,
    private val context:Application
) : ViewModel() {

    private val _state = mutableStateOf(PropertyDetailState())
    val state: State<PropertyDetailState> = _state

    private val _comment = mutableStateOf("")
    val comment: State<String> = _comment

    private val _rating = mutableStateOf(0)
    val rating: State<Int> = _rating

    private val _propertyId = mutableStateOf(0)
    private val propertyId: State<Int> = _propertyId

    private val _userName = mutableStateOf("")
    private val userName: State<String> = _userName

    private val _userId = mutableStateOf(0)
    private val userId: State<Int> = _userId




    init {
        savedStateHandle.get<Int>("id")?.let {
            if (it != 0){
                getPropertyDetail(it)
                _propertyId.value = it
            }
        }
        viewModelScope.launch {
            if ( allUseCases.verificationAlreadyLoginUseCase.readUserKey(
                    Commons.ALREADY_LOGIN_USER
                ) == Commons.ALREADY_LOGIN_USER){
                    _state.value = state.value.copy(
                        isLogin = true
                    )
            }else{
                _state.value = state.value.copy(
                    isLogin = false
                )
            }
            allUseCases.readUserDataUseCase().collect{
                _userName.value = it.name?:""
                _userId.value = it.id?:0
            }

        }

    }
//    fun sendInt(id:Int){
//    Log.d("tag",id.toString())
//        getPropertyDetail(id)
//        _propertyId.value = id
//        viewModelScope.launch {
//            if ( allUseCases.verificationAlreadyLoginUseCase.readUserKey(
//                    Commons.ALREADY_LOGIN_USER
//                ) == Commons.ALREADY_LOGIN_USER){
//                _state.value = state.value.copy(
//                    isLogin = true
//                )
//            }else{
//                _state.value = state.value.copy(
//                    isLogin = false
//                )
//            }
//            allUseCases.readUserDataUseCase().collect{
//                _userName.value = it.name?:""
//                _userId.value = it.id?:0
//            }
//
//        }
//    }




    fun onUiEvent(event: PropertyUiEvent){
        when(event){
            is PropertyUiEvent.EnterComment ->{
                _comment.value = event.comment
            }
            is PropertyUiEvent.OnClickRating ->{
                if (rating.value == event.rating){
                    _rating.value = rating.value-1
                }else {
                    _rating.value = event.rating
                }
            }
            is PropertyUiEvent.OnSwipeRefresh ->{
                getPropertyDetail(propertyId.value)
            }
            is PropertyUiEvent.AllReviews ->{
                _state.value = state.value.copy(
                    onlyTwoComments = !state.value.onlyTwoComments
                )
            }
            is PropertyUiEvent.SubmitReview ->{
                if (state.value.isLogin) {
                    getResponsePostComment()
                }else{
                    val i = Intent(context.applicationContext,AuthenticationActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    context.startActivity(i)
                }
            }
        }
    }
    private fun getResponsePostComment(){
        allUseCases.postCommentUseCase(
            PostCommentDto(
                comment = comment.value,
                property_id = propertyId.value,
                rating = rating.value,
                username = userName.value,
                user_id = userId.value
            )
        ).onEach { result->
            when(result) {
                is Resource.Loading -> {
                    _state.value = state.value.copy(
                        commentBtnLoading = true
                    )
                }
                is Resource.Success->{
                    _state.value = state.value.copy(
                        commentBtnLoading = false
                    )
                    Toast.makeText(
                        context.applicationContext,
                        result.data.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
                is Resource.Error->{
                    _state.value = state.value.copy(
                        commentBtnLoading = false
                    )
                    Toast.makeText(
                        context.applicationContext,
                        result.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }.launchIn(viewModelScope)
    }

    private fun getPropertyDetail(id:Int) {
        allUseCases.getOnePropertyUseCase(id).onEach { result->
            when(result) {
                is Resource.Loading -> {
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    if (result.data.status == 1){
                        _state.value = state.value.copy(
                            about_property = result.data.data?.about_property?:"",
                            booking_amount = result.data.data?.booking_amount?:"",
                            buildup_area = result.data.data?.buildup_area?:"",
                            carpet_area = result.data.data?.carpet_area?:"",
                            flat_type = result.data.data?.flat_type?:"",
                            net_price = result.data.data?.net_price?:"",
                            pic_four = result.data.data?.pic_four?:"",
                            pic_one = result.data.data?.pic_one?:"",
                            pic_three = result.data.data?.pic_three?:"",
                            pic_two = result.data.data?.pic_two?:"",
                            price_sq_ft = result.data.data?.price_sq_ft?:"",
                            property_address = result.data.data?.property_address?:"",
                            property_amenities = result.data.data?.property_amenities?.split(",")?: emptyList(),
                            property_name = result.data.data?.property_name?:"",
                            property_type = result.data.data?.property_type?:"",
                            super_buildup_area = result.data.data?.super_buildup_area?:"",
                            vendor_name = result.data.data?.vendor_data?.vendor_name?:"",
                            vendor_type = result.data.data?.vendor_data?.vendor_type?:"",
                            comments = result.data.data?.comments?: emptyList(),
                            isLoading = false,
                            averageRating = result.data.data?.comments?.map {
                                it.rating
                            }?.sumOf {
                                it?:0
                            }?.toFloat()?.div(result.data.data.comments.size.toFloat())?:0.0F
                        )
                    }
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        errorMessage = result.message,
                        isLoading = false

                    )
                }
            }
        }.launchIn(viewModelScope)
    }


}