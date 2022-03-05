package com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens

sealed class Screens(val route: String){
    object SplashScreen: Screens(
        route = "splash_screen"
    )
    object OnBoardingScreen: Screens(
        route = "on_boarding_screen"
    )

 }
