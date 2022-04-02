package com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens

sealed class Screens(val route:String){
    object PropertyDetail:Screens("propertyDetail_route")
}
