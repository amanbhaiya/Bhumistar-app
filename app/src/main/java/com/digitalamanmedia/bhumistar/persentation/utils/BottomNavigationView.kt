package com.digitalamanmedia.bhumistar.persentation.utils

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun BottomNavigationViewScreen(
    navController: NavController,
    items: List<BottomNavScreens>,
    modifier:Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomAppBar(
        cutoutShape = RoundedCornerShape(50),
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 0.dp,
        modifier =modifier
    ){
        items.forEachIndexed{ index,screens ->
            if (index != 3){ //
                    // your implementation
                    BottomNavigationItem(
                        selected = currentDestination?.route==screens.route,//||screens.innerScreens.contains(currentDestination?.route),
                        onClick = {
                          Log.d("Tagging",screens.title)
                            Log.d("Tagging",currentDestination?.route?:"")
                            try {
                                if (currentDestination?.route == screens.route) {
                                    return@BottomNavigationItem
                                }else{
                                    navController.navigate(screens.route){
                                        popUpTo(navController.graph.findStartDestination().id){
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState=true
                                    }
                                }
//                                navController.backQueue.forEach {
//                                    Log.d("taga",it.destination.route.toString()+"\n\n")
//
//                                }
//                                val route = navController.backQueue.find {
//                                    it.destination.route?.contains(screens.route)?:false
//                                } != null
//                                if (route){
//                                    if (currentDestination?.route == screens.route) {
//                                        return@BottomNavigationItem
//                                    }else{
//                                        navController.popBackStack()
//                                        navController.navigate(screens.route){
//                                            launchSingleTop = true
//                                            restoreState=true
//                                        }
//                                    }
//
//                                }else{
//                                    navController.navigate(screens.route){
//                                        launchSingleTop = true
//                                        restoreState=true
//                                    }
//
//                                }
                            } catch (e: IllegalStateException) {

                            }

                        },
                        icon = { Icon(
                            imageVector = screens.icons,
                            contentDescription = null )
                        },
                        label = { Text(text = screens.title) },
                        alwaysShowLabel = false,
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White,
                    )
                } else {
                //Empty BottomNavigationItem
                BottomNavigationItem(
                    icon = {},
                    label = {  },
                    selected = false,
                    onClick = {  },
                    enabled = false
                )
            }




        }

    }

}




