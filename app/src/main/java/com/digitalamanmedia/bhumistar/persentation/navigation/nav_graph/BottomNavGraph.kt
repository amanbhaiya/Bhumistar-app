package com.digitalamanmedia.bhumistar.persentation.navigation.nav_graph


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.contacts.ContactScreen
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.home.HomeScreen
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.profile.ProfileScreen
import com.digitalamanmedia.bhumistar.persentation.main_screens.screens.search.SearchScreen

import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens

@ExperimentalMaterialApi
@Composable
fun BottomNavHost(
    navControllerChild: NavHostController,
    navControllerRoot: NavController
) {

    NavHost(
        navController = navControllerChild,
        startDestination = BottomNavScreens.Home.route

    ){
        composable(BottomNavScreens.Home.route){
            HomeScreen(navControllerRoot = navControllerRoot, navControllerChild = navControllerChild)
        }
        composable(BottomNavScreens.Contacts.route){
            ContactScreen()
        }
        composable(
            BottomNavScreens.Search.route+"?verified={verified}",
            arguments = listOf(
                navArgument(
                    name = "verified"
                ){
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ){
            SearchScreen(navControllerRoot = navControllerRoot)
        }
        composable(BottomNavScreens.Profile.route){
            ProfileScreen(navControllerRoot = navControllerRoot)
        }
    }

}