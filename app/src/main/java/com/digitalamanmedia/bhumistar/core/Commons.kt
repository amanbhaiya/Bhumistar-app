package com.digitalamanmedia.bhumistar.core


import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.domain.modal.property_modal.CommentsDataModal
import com.digitalamanmedia.bhumistar.persentation.onBoarding.utils.OnBoardingItem
import java.math.RoundingMode

class Commons {
    companion object{
        const val BOOLEAN = "Bhumistar DataStore"
        const val TRUE = "true"
        const val ALREADY_LOGIN_VENDOR = "Already_login_vendor"
        const val V_ID = "V_id"
        const val V_NAME = "V_name"
        const val V_EMAIL = "V_email"
        const val V_NUMBER = "V_number"
        const val VENDOR_TYPE = "Vendor_type"
        const val ALREADY_LOGIN_USER = "Already_login_User"
        const val ID = "id"
        const val NAME = "Name"
        const val EMAIL = "Email"
        const val NUMBER = "Number"
        const val STATE = "State"
        const val CITY = "City"
        const val PIN_CODE = "PinCode"
        const val PROFILE_PICTURE = "ProfilePicture"
        const val BASE_URL = "https://givni.in/aky/"
        const val PROPERTY_IMAGE_URL = "https://givni.in/aky/v3/images/"
        const val IMAGE_URL = "https://givni.in/aky/v1/user_images/"
        const val MESSAGE = "Bhumistar registration, Your one time password is "
        const val SUCCESS_OTP = "Your number verified successfully..."
        const val FAILED_OTP = "Wrong OTP..."
        const val FULL_OTP = "Please enter a full OTP..."
        const val VALID_PASSWORD = "Password not match..."
        const val UNKNOWN_ERROR = "Unknown error..."
        const val ERROR = "An unexpected error occurred..."
        const val INTERNET_ERROR = "Check your internet connection..."
        const val SUCCESS_UPLOAD_PROPERTY = "Your property has been Listed..."
        private const val OFFER_PIC_ONE = "bhumi1.png"
        private const val OFFER_PIC_TWO = "bhumi2.png"
        private const val OFFER_PIC_THREE = "bhumi3.png"
        private const val OFFER_PIC_FOUR = "bhumi4.png"
        private const val OFFER_PIC_FIVE = "bhumi5.png"
        const val LOGO = "Bhumistar.jpg"
        const val HOME_ROUTE = "home_route"
        const val SEARCH_ROUTE = "search_route"
        const val ROOT_ROUTE = "root_route"
        const val CHANNEL_ID_1 = "channel1"
        const val CHANNEL_ID_2 = "channel2"
        const val CHANNEL_ID_3 = "channel3"




        val pictures = listOf(
            OFFER_PIC_ONE, OFFER_PIC_TWO, OFFER_PIC_THREE, OFFER_PIC_FOUR, OFFER_PIC_FIVE
        )

        fun getLight():List<OnBoardingItem>{
            return listOf(
                OnBoardingItem( onImg = R.drawable.bhumistaronelight),
                OnBoardingItem( onImg = R.drawable.bhumistartwolight),
                OnBoardingItem( onImg = R.drawable.bhumistarthreelight)
            )
        }
        fun getDark():List<OnBoardingItem>{
            return listOf(
                OnBoardingItem( onImg = R.drawable.bhumistaronedark),
                OnBoardingItem( onImg = R.drawable.bhumistartwodark),
                OnBoardingItem( onImg = R.drawable.bhumistarthreedark)
            )
        }
        fun getTab():List<String>{
            return listOf(
                 "Vendor","User"
            )
        }
        fun getRadioButtons():List<String>{
            return listOf(
                "Owner","Agent","Builder"
            )
        }
        fun getPropertyTypeButtons():List<String>{
            return listOf(
                "Land","Plot","Apartment","Villa","Flat"
            )
        }
        const val LAND = "Land"
        const val PLOT = "Plot"
        const val APARTMENT = "Apartment"
        const val VILLA = "Villa"
        const val FLAT = "Flat"
        fun getFlatsButtons():List<String>{
            return listOf(
                "1BHK","2BHK","3BHK","4BHK","5BHK","6BHK","7BHK","8BHK","8+BHK"
            )
        }



    }
}