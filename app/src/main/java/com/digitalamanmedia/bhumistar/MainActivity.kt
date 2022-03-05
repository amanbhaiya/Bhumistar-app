package com.digitalamanmedia.bhumistar


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.persentation.navigation.nav_graph.BottomNavHost
import com.digitalamanmedia.bhumistar.persentation.utils.ActionBar
import com.digitalamanmedia.bhumistar.persentation.utils.BottomNavigationViewScreen
import com.digitalamanmedia.bhumistar.persentation.utils.NavigationDrawer
import com.digitalamanmedia.bhumistar.ui.theme.BhumistarTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val scope = rememberCoroutineScope()
            val scaffoldState = rememberScaffoldState()

            val list = listOf(
                BottomNavScreens.Home,
                BottomNavScreens.Verified,
                BottomNavScreens.Search,
                BottomNavScreens.Favorites,
                BottomNavScreens.Profile
            )
            BhumistarTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        scaffoldState = scaffoldState,
                        drawerContent = {
                            NavigationDrawer()
                        },
                        topBar = {
                            ActionBar(
                                openDrawer = {
                                    scope.launch {

                                        scaffoldState.drawerState.open()
                                    }
                                }
                            )
                        },
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    navController.navigate(BottomNavScreens.Search.route){
                                        launchSingleTop = true
                                        popUpTo(navController.graph.findStartDestination().id){
                                            saveState=true
                                        }
                                        restoreState=true
                                    }
                                          },
                                shape = RoundedCornerShape(50),
                                backgroundColor = MaterialTheme.colors.primary
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "",
                                    tint = Color.White
                                )
                            }
                        },
                        drawerGesturesEnabled = true,
                        isFloatingActionButtonDocked = true,
                        floatingActionButtonPosition = FabPosition.Center,
                        bottomBar = {
                            BottomNavigationViewScreen(
                                navController = navController,
                                items = list
                            )
                        }
                    ) {


                        BottomNavHost(navHostController = navController)


                    }
                }
            }
        }
    }
}


