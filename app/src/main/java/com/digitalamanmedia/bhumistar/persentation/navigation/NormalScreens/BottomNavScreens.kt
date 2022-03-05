package com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens
import androidx.annotation.DrawableRes
import com.digitalamanmedia.bhumistar.R

sealed class BottomNavScreens(val route:String, val title:String, @DrawableRes val icons: Int){


    object Home: BottomNavScreens(
        route="home_route",
        title= "Home",
        icons= R.drawable.home
    )
    object Verified: BottomNavScreens(
        route="verified_route",
        title= "Verified",
        icons= R.drawable.verified
    )
    object Search: BottomNavScreens(
        route="search_route",
        title= "Search",
        icons= R.drawable.search
    )
    object Favorites: BottomNavScreens(
        route="favorites_route",
        title= "Favorites",
        icons= R.drawable.favorite
    )
    object Profile: BottomNavScreens(
        route="profile_route",
        title= "Profile",
        icons= R.drawable.profile
    )

}




