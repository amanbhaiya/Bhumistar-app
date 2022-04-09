package com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavScreens(
    val route:String,
    val title:String,
    val icons: ImageVector,
   // val innerScreens:List<String> = emptyList()
){


    object Home: BottomNavScreens(
        route="home_route",
        title= "Home",
        icons= Icons.Default.Home,
       // innerScreens = listOf("DetailList_route/?verified={verified}")
    )
    object Search: BottomNavScreens(
        route="search_route",
        title= "Search",
        icons= Icons.Default.Search
    )

    object Profile: BottomNavScreens(
        route="profile_route",
        title= "Profile",
        icons= Icons.Default.Person
    )
    object Contacts: BottomNavScreens(
        route="contacts_route",
        title= "Contacts",
        icons= Icons.Default.Phone
    )
//    object DetailList: BottomNavScreens(
//        route="DetailList_route",
//        title= "Contacts",
//        icons= Icons.Default.Phone
//    )



}




