package com.digitalamanmedia.bhumistar.persentation.navigation.nav_graph


import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.persentation.screens.favorites.FavoriteScreen
import com.digitalamanmedia.bhumistar.persentation.screens.home.HomeScreen
import com.digitalamanmedia.bhumistar.persentation.screens.profile.ProfileScreen
import com.digitalamanmedia.bhumistar.persentation.screens.search.SearchScreen
import com.digitalamanmedia.bhumistar.persentation.screens.verified.VerifiedScreen

@ExperimentalMaterialApi
@Composable
fun BottomNavHost(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = BottomNavScreens.Home.route,

    ){
        composable(BottomNavScreens.Home.route){
            HomeScreen()
        }
        composable(BottomNavScreens.Verified.route){
            VerifiedScreen()
        }
        composable(BottomNavScreens.Search.route){
            SearchScreen(navController = navHostController)
        }
        composable(BottomNavScreens.Favorites.route){
            FavoriteScreen()
        }
        composable(BottomNavScreens.Profile.route){
            ProfileScreen()
        }


    }

}