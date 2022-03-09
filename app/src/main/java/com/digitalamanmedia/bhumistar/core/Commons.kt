package com.digitalamanmedia.bhumistar.core

import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.persentation.onBoarding.utils.OnBoardingItem
class Commons {
    companion object{
        const val BOOLEAN = "Boolean"
        const val NAME = "Aman"
        const val BASE_URL = "https://givni.in/aky/"
        const val MESSAGE = "Bhumistar registration, Your one time password is "
        const val SUCCESS_OTP = "Your number verified successfully..."
        const val FAILED_OTP = "Wrong OTP..."
        const val FULL_OTP = "Please enter a full OTP..."
        const val VALID_NUMBER = "Please enter a valid number..."
        const val UNKNOWN_ERROR = "Unknown error..."
        const val ERROR = "An unexpected error occurred..."
        const val INTERNET_ERROR = "Check your internet connection..."
        const val ALL_FIELD = "All fields required..."


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



    }
}