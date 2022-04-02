package com.digitalamanmedia.bhumistar.persentation


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.digitalamanmedia.bhumistar.core.Commons.Companion.ALREADY_LOGIN_USER
import com.digitalamanmedia.bhumistar.core.Commons.Companion.ALREADY_LOGIN_VENDOR
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.authentication.AuthenticationActivity
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.persentation.navigation.nav_graph.BottomNavHost
import com.digitalamanmedia.bhumistar.persentation.property_uplaod.PropertyUploadActivity
import com.digitalamanmedia.bhumistar.persentation.utils.ActionBar
import com.digitalamanmedia.bhumistar.persentation.utils.BottomNavigationViewScreen
import com.digitalamanmedia.bhumistar.persentation.utils.NavigationDrawer
import com.digitalamanmedia.bhumistar.ui.theme.BhumistarTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var allUseCases: AllUseCases
    @RequiresApi(Build.VERSION_CODES.N)
    @ExperimentalMaterialApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val scaffoldState = rememberScaffoldState()

            val list = listOf(
                BottomNavScreens.Home,
                BottomNavScreens.Search,
                BottomNavScreens.Profile,
                BottomNavScreens.Contacts,
            )
            BhumistarTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        scaffoldState = scaffoldState,
                        topBar = {
                            ActionBar(
                                registerVendor = {
                                    lifecycleScope.launchWhenCreated {
                                        if (allUseCases.vendorVerificationAlreadyLoginUseCase.readVendorrKey(
                                                ALREADY_LOGIN_VENDOR
                                            ) == ALREADY_LOGIN_VENDOR
                                        ){
                                            startActivity(
                                                Intent(
                                                    applicationContext,
                                                    PropertyUploadActivity::class.java
                                                )
                                            )
                                        }
                                        else {
                                            Toast.makeText(this@MainActivity,"Login/Register as Vendor",Toast.LENGTH_LONG).show()
                                            startActivity(
                                                Intent(
                                                    applicationContext,
                                                    AuthenticationActivity::class.java
                                                )
                                            )
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

                                        navController.navigate(BottomNavScreens.Contacts.route){

                                            navController.graph.route?.let{screen_route->
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
                                    imageVector = Icons.Default.Phone,
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
                                navController = navController,
                                items = list,
                                modifier = Modifier.clip(
                                    shape = RoundedCornerShape(topStart = 5.dp, topEnd = 5.dp)
                                )
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


