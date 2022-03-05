package com.digitalamanmedia.bhumistar.persentation.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.ui.theme.Bhumistar
import com.digitalamanmedia.bhumistar.ui.theme.BhumistarDark
import com.digitalamanmedia.bhumistar.ui.theme.UnSelected

@Composable
fun BottomNavigationViewScreen(navController: NavController, items: List<BottomNavScreens>) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomAppBar(
        cutoutShape = RoundedCornerShape(50),
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 0.dp,
        modifier = Modifier.clip(shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
    ){
        items.forEachIndexed{ index,screens ->
            if (index != 2){ //
                    // your implementation
                    BottomNavigationItem(
                        selected = currentDestination?.route==screens.route,
                        onClick = {
                            navController.navigate(screens.route){
                                launchSingleTop=true
                                popUpTo(navController.graph.findStartDestination().id){
                                    saveState=true
                                }
                                restoreState=true
                            }
                        },
                        icon = { Icon(
                            painter = painterResource(id = screens.icons),
                            contentDescription = null )
                        },
                        label = { Text(text = screens.title) },
                        alwaysShowLabel = false,
                        selectedContentColor = Color.White,
                        unselectedContentColor = Color.White,
                        //modifier = Modifier.background(Bhumistar)
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

