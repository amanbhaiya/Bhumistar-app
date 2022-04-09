package com.digitalamanmedia.bhumistar.persentation.main_screens

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.Screens
import com.digitalamanmedia.bhumistar.persentation.navigation.nav_graph.BottomNavHost
import com.digitalamanmedia.bhumistar.persentation.utils.ActionBar
import com.digitalamanmedia.bhumistar.persentation.utils.BottomNavigationViewScreen
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalMaterialApi
@Composable
fun MainScreen(
    navControllerChild:NavHostController,
    allUseCases:AllUseCases,
    navControllerRoot:NavHostController
) {
    val scaffoldState = rememberScaffoldState()
    val lifecycleScope = rememberCoroutineScope()
    val context = LocalContext.current

    val list = listOf(
        BottomNavScreens.Home,
        BottomNavScreens.Contacts,
        BottomNavScreens.Profile,
        BottomNavScreens.Search,
    )
    val constant = 1
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ActionBar(
                listProperty = {
                    lifecycleScope.launch {
                        if (allUseCases.vendorVerificationAlreadyLoginUseCase.readVendorrKey(
                                Commons.ALREADY_LOGIN_VENDOR
                            ) == Commons.ALREADY_LOGIN_VENDOR
                        ){
                            navControllerRoot.navigate(Screens.ListProperty.route)
                        }
                        else {
                            Toast.makeText(context,"Login/Register as Vendor", Toast.LENGTH_LONG).show()
                            navControllerRoot.navigate(Screens.Authentication.route+"?from=$constant")
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    try {
                        // The navigation code that throw this exception

                        navControllerChild.navigate(BottomNavScreens.Search.route){

                            navControllerChild.graph.route?.let{screen_route->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop=true
                            restoreState=true
                        }
                    } catch (e: IllegalStateException) {

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
        floatingActionButtonPosition = FabPosition.End,
        bottomBar = {
            BottomNavigationViewScreen(
                navController = navControllerChild,
                items = list,
                modifier = Modifier.clip(
                    shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)
                )
            )
        }
    ) {


        BottomNavHost(navControllerChild = navControllerChild,navControllerRoot = navControllerRoot)

    }

}