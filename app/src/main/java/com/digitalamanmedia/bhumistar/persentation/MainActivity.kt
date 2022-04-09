package com.digitalamanmedia.bhumistar.persentation


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.*
import androidx.navigation.compose.rememberNavController
import com.digitalamanmedia.bhumistar.domain.use_cases.AllUseCases
import com.digitalamanmedia.bhumistar.persentation.navigation.nav_graph.RootNavGraph
import com.digitalamanmedia.bhumistar.ui.theme.BhumistarTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalPermissionsApi
@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalMaterialApi
@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var allUseCases: AllUseCases
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navControllerRoot = rememberNavController()
            val navControllerChild = rememberNavController()


            BhumistarTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    RootNavGraph(
                        navControllerRoot = navControllerRoot,
                        allUseCases = allUseCases,
                        navControllerChild = navControllerChild
                    )

                }
            }
        }
    }
}


