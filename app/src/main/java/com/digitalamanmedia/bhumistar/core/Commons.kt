package com.digitalamanmedia.bhumistar.core

import com.digitalamanmedia.bhumistar.R
import com.digitalamanmedia.bhumistar.persentation.onBoarding.utils.OnBoardingItem
class Commons {
    companion object{
        const val BOOLEAN = "Boolean"
        const val NAME = "Aman"

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
        fun items():List<String>{
            return listOf(
                "Owner","Agent","Builder","Profile","KYC Details","Vendor","User",
                "Owner","Agent","Builder","Profile","KYC Details","Vendor","User"
            )
        }


    }
}