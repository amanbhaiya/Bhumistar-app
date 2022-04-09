package com.digitalamanmedia.bhumistar.persentation.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.UserAuth
import com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.VendorAuth
import com.google.accompanist.pager.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch



@ExperimentalPagerApi
@Composable
fun AuthScreen(
    navControllerRoot: NavController,
    from:Int
) {
    val scope= rememberCoroutineScope()
    val pagerState= rememberPagerState(initialPage = 0)
    val  tabTitles = Commons.getTab()
    val tabIndex by remember { mutableStateOf(0) }

    Column {

        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPositions -> // 3.
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(
                        pagerState = pagerState,
                        tabPositions = tabPositions,
                    ),
                    color = Color.White
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .clip(
                    shape = RoundedCornerShape(
                        bottomStart = 15.dp,
                        bottomEnd = 15.dp
                    )
                ),
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    modifier = Modifier,
                    selected = tabIndex == index,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },

                    text = {
                        Text(
                            text = title,
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    },

                    )
            }
        }
        HorizontalPager( // 4.
            count = tabTitles.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) { tabIndex ->
            when(tabIndex){
                0 -> VendorAuth(
                    navControllerRoot = navControllerRoot,
                    from = from
                )
                1 -> UserAuth(
                    navControllerRoot = navControllerRoot,
                    from = from
                )

            }
        }
    }
}



