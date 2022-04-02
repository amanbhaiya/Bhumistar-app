package com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens
import androidx.annotation.DrawableRes
import com.digitalamanmedia.bhumistar.R

sealed class BottomNavScreens(val route:String, val title:String, @DrawableRes val icons: Int){


    object Home: BottomNavScreens(
        route="home_route",
        title= "Home",
        icons= R.drawable.home
    )
    object Search: BottomNavScreens(
        route="search_route",
        title= "Search",
        icons= R.drawable.search
    )

    object Profile: BottomNavScreens(
        route="profile_route",
        title= "Profile",
        icons= R.drawable.profile
    )
    object Contacts: BottomNavScreens(
        route="contacts_route",
        title= "Contacts",
        icons= R.drawable.phone
    )


}




