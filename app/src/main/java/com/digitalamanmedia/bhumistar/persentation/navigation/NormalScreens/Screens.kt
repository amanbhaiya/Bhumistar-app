package com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens

sealed class Screens (val route:String){
    object Splash: Screens(
        route="splash_route"
    )
    object OnBoarding: Screens(
        route="on_boarding_route"
    )
    object Authentication: Screens(
        route="authentication_route"
    )
    object ListProperty: Screens(
        route="list_property_route"
    )
    object DetailScreen: Screens(
        route="detail_route"
    )
    object MainScreen: Screens(
        route="main_route"
    )
}