package com.digitalamanmedia.bhumistar.persentation.navigation.nav_graph


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.Screens
import com.digitalamanmedia.bhumistar.persentation.screens.PropertyDetailScreen
import com.digitalamanmedia.bhumistar.persentation.screens.profile.ProfileScreen
import com.digitalamanmedia.bhumistar.persentation.screens.search.SearchScreen
import com.digitalamanmedia.bhumistar.persentation.screens.contacts.ContactScreen
import com.digitalamanmedia.bhumistar.persentation.screens.home.HomeScreen

@ExperimentalMaterialApi
@Composable
fun BottomNavHost(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = BottomNavScreens.Home.route,

    ){
        composable(BottomNavScreens.Home.route){
            HomeScreen(navController = navHostController)
        }
        composable(BottomNavScreens.Contacts.route){
            ContactScreen()
        }
        composable(
            BottomNavScreens.Search.route
        ){
            SearchScreen(navController = navHostController)
        }
        composable(BottomNavScreens.Profile.route){
            ProfileScreen()
        }
        composable(
            Screens.PropertyDetail.route+"?id={id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            PropertyDetailScreen()
        }
    }

}