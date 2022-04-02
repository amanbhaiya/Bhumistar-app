package com.digitalamanmedia.bhumistar.persentation.property_uplaod.viewModel

import android.app.Application
import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.digitalamanmedia.bhumistar.core.utils.EncodedImages
import com.digitalamanmedia.bhumistar.core.utils.Resource
import com.digitalamanmedia.bhumistar.data.remote.dto.PropertyDto.ListPropertyDto
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListPropertyViewModal @Inject constructor(
    private val allUseCases: AllUseCases,
    private val context:Application
) : ViewModel(){

    private val _propertyType = mutableStateOf("")
    val propertyType: State<String> = _propertyType

    private val _flatType = mutableStateOf("")
    val flatType: State<String> = _flatType

    private val _propertyName = mutableStateOf("")
    val propertyName: State<String> = _propertyName

    private val _propertyAddress = mutableStateOf("")
    val propertyAddress: State<String> = _propertyAddress

    private val _netPrice = mutableStateOf("")
    val netPrice: State<String> = _netPrice

    private val _bookingAmount = mutableStateOf("")
    val bookingAmount: State<String> = _bookingAmount

    private val _priceSqFt = mutableStateOf("")
    val priceSqFt: State<String> = _priceSqFt

    private val _carpetArea = mutableStateOf("")
    val carpetArea: State<String> = _carpetArea

    private val _buildupArea = mutableStateOf("")
    val buildupArea: State<String> = _buildupArea

    private val _superBuildupArea = mutableStateOf("")
    val superBuildupArea: State<String> = _superBuildupArea

    private val _propertyAmenities = mutableStateOf("")
    val propertyAmenities: State<String> = _propertyAmenities

    private val _aboutProperty = mutableStateOf("")
    val aboutProperty: State<String> = _aboutProperty

    private val _picOne = mutableStateOf("")
    private val picOne: State<String> = _picOne

    private val _picTwo = mutableStateOf("")
    private val picTwo: State<String> = _picTwo

    private val _picThree = mutableStateOf("")
    private val picThree: State<String> = _picThree

    private val _picFour = mutableStateOf("")
    private val picFour: State<String> = _picFour

    private val _id = mutableStateOf(0)
    val id: State<Int> = _id

    private val _state = mutableStateOf(PropertyState())
    val state: State<PropertyState> = _state

    private val _eventFlow = MutableSharedFlow<ListPropertySnack>()
    val eventFlow = _eventFlow.asSharedFlow()


    init {
        viewModelScope.launch {
             allUseCases.readVendorDataUseSase().collect{
                 _id.value = it.vendor_id?:0
             }
        }
    }

    fun onUiEvent(event: ListPropertyUiEvent){
        when(event){
            is ListPropertyUiEvent.EnterPropertyType->{
                _propertyType.value = event.propertyType
                if (propertyType.value == "Flat"){
                    _state.value = state.value.copy(
                        isVisible = true
                    )
                }else{
                    _state.value = state.value.copy(
                        isVisible = false
                    )
                }
            }
            is ListPropertyUiEvent.EnterFlatType->{
                _flatType.value = event.propertyType
            }
            is ListPropertyUiEvent.EnterPropertyName->{
                _propertyName.value = event.propertyName
            }
            is ListPropertyUiEvent.EnterPropertyAddress->{
                _propertyAddress.value = event.propertyAddress
            }
            is ListPropertyUiEvent.EnterNetPrice->{
                _netPrice.value = event.netPrice
            }
            is ListPropertyUiEvent.EnterBookingAmount->{
                _bookingAmount.value = event.bookingAmount
            }
            is ListPropertyUiEvent.EnterPriceSQFT->{
                _priceSqFt.value = event.priceSQFT
            }
            is ListPropertyUiEvent.EnterCarpetArea->{
                _carpetArea.value = event.carpetArea
            }
            is ListPropertyUiEvent.EnterBuildupArea->{
                _buildupArea.value = event.buildupArea
            }
            is ListPropertyUiEvent.EnterSuperBuildupArea->{
                _superBuildupArea.value = event.superBuildupArea
            }
            is ListPropertyUiEvent.EnterPropertiesAmenities->{
                _propertyAmenities.value = event.propertiesAmenities
            }
            is ListPropertyUiEvent.EnterAboutProperty->{
                _aboutProperty.value = event.aboutProperty
            }
            is ListPropertyUiEvent.Submit->{
//                Toast.makeText(context.applicationContext,picOne.value,Toast.LENGTH_LONG).show()
                Log.d("tag",id.value.toString())
                listPropertyResponse()
            }
            is ListPropertyUiEvent.GetPicOneUri->{
                _state.value = state.value.copy(
                    picOne = event.picOneUri
                )
                viewModelScope.launch {
                    _picOne.value = EncodedImages.encodedString(
                        uri = event.picOneUri,
                        context = context
                    )
                }
            }
            is ListPropertyUiEvent.GetPicTwoUri->{
                _state.value = state.value.copy(
                    picTwo = event.picTwoUri
                )
                _picTwo.value = EncodedImages.encodedString(
                    uri = event.picTwoUri,
                    context = context
                )
            }
            is ListPropertyUiEvent.GetPicThreeUri->{
                _state.value = state.value.copy(
                    picThree = event.picThreeUri
                )
                _picThree.value = EncodedImages.encodedString(
                    uri = event.picThreeUri,
                    context = context
                )
            }
            is ListPropertyUiEvent.GetPicFourUri->{
                _state.value = state.value.copy(
                    picFour = event.picFourUri
                )
                _picFour.value = EncodedImages.encodedString(
                    uri = event.picFourUri,
                    context = context
                )
            }

        }
    }

    private fun listPropertyResponse(){
        allUseCases.listPropertyUseCase(
            listPropertyDto = ListPropertyDto(
                vendor_id = id.value,
                about_property = aboutProperty.value,
                booking_amount = bookingAmount.value,
                buildup_area = buildupArea.value,
                carpet_area = carpetArea.value,
                flat_type = flatType.value,
                net_price = netPrice.value,
                pic_four = picFour.value,
                pic_one = picOne.value,
                pic_three = picThree.value,
                pic_two = picTwo.value,
                price_sq_ft = priceSqFt.value,
                property_address = propertyAddress.value,
                property_amenities = propertyAmenities.value,
                property_name = propertyName.value,
                property_type = propertyType.value,
                super_buildup_area = superBuildupArea.value
            )
        ).onEach { result->
            when(result){
                is Resource.Loading->{
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Resource.Success->{
                    _eventFlow.emit(ListPropertySnack.ShowSnackBar(result.data.message))
                    _state.value = state.value.copy(
                        isLoading = false
                    )
                }
                is Resource.Error->{
                    _eventFlow.emit(ListPropertySnack.ShowSnackBar(result.message))
                    _state.value = state.value.copy(
                        isLoading = false
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
    sealed class ListPropertySnack{
        data class ShowSnackBar(val message: String): ListPropertySnack()
    }
}