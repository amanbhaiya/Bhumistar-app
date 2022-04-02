package com.digitalamanmedia.bhumistar.persentation.property_uplaod.viewModel

import android.net.Uri

sealed class ListPropertyUiEvent{
    data class EnterPropertyType(val propertyType:String):ListPropertyUiEvent()
    data class EnterFlatType(val propertyType:String):ListPropertyUiEvent()
    data class EnterPropertyName(val propertyName:String):ListPropertyUiEvent()
    data class EnterPropertyAddress(val propertyAddress:String):ListPropertyUiEvent()
    data class EnterNetPrice(val netPrice:String):ListPropertyUiEvent()
    data class EnterBookingAmount(val bookingAmount:String):ListPropertyUiEvent()
    data class EnterPriceSQFT(val priceSQFT:String):ListPropertyUiEvent()
    data class EnterCarpetArea(val carpetArea:String):ListPropertyUiEvent()
    data class EnterBuildupArea(val buildupArea:String):ListPropertyUiEvent()
    data class EnterSuperBuildupArea(val superBuildupArea:String):ListPropertyUiEvent()
    data class EnterPropertiesAmenities(val propertiesAmenities:String):ListPropertyUiEvent()
    data class EnterAboutProperty(val aboutProperty:String):ListPropertyUiEvent()
    data class GetPicOneUri(val picOneUri:Uri?):ListPropertyUiEvent()
    data class GetPicTwoUri(val picTwoUri:Uri?):ListPropertyUiEvent()
    data class GetPicThreeUri(val picThreeUri:Uri?):ListPropertyUiEvent()
    data class GetPicFourUri(val picFourUri:Uri?):ListPropertyUiEvent()
    object Submit:ListPropertyUiEvent()

}
