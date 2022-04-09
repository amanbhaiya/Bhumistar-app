package com.digitalamanmedia.bhumistar.persentation.navigation.nav_graph

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.authentication.AuthScreen
import com.digitalamanmedia.bhumistar.persentation.main_screens.MainScreen
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.Screens
import com.digitalamanmedia.bhumistar.persentation.onBoarding.onboarding_screen.OnBoardingScreen
import com.digitalamanmedia.bhumistar.persentation.property_uplaod.ListPropertyScreen
import com.digitalamanmedia.bhumistar.persentation.screens.PropertyDetailScreen
import com.digitalamanmedia.bhumistar.persentation.splash.AppSplashScreen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@ExperimentalPermissionsApi
@ExperimentalMaterialApi
@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalPagerApi
@Composable
fun RootNavGraph(
    navControllerRoot:NavHostController,
    allUseCases:AllUseCases,
    navControllerChild: NavHostController
) {
    NavHost(
        navController = navControllerRoot,
        startDestination = Screens.Splash.route,

        ){
        composable(Screens.Splash.route){
            AppSplashScreen(
                navControllerRoot = navControllerRoot,
                allUseCases = allUseCases
            )
        }
        composable(Screens.OnBoarding.route){
            OnBoardingScreen(
                allUseCases = allUseCases,
                navControllerRoot = navControllerRoot
            )
        }
        composable(
            Screens.Authentication.route+"?from={from}",
            arguments = listOf(
                navArgument("from"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            val from = it.arguments?.getInt("from")
            AuthScreen(
                navControllerRoot = navControllerRoot,
                from = from?:0
            )
        }
        composable(Screens.MainScreen.route){
            MainScreen(
                navControllerChild = navControllerChild,
                allUseCases = allUseCases,
                navControllerRoot = navControllerRoot
            )
        }
        composable(Screens.ListProperty.route){
           ListPropertyScreen(navControllerRoot = navControllerRoot)
        }
        composable(
            Screens.DetailScreen.route+"?id={id}",
            arguments = listOf(
                navArgument("id"){
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ){
            PropertyDetailScreen(navControllerRoot = navControllerRoot)
        }
    }

}