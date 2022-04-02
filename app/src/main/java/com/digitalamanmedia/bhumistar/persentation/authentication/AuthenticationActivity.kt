package com.digitalamanmedia.bhumistar.persentation.authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import com.digitalamanmedia.bhumistar.core.Commons

import com.digitalamanmedia.bhumistar.ui.theme.BhumistarTheme
import com.google.accompanist.pager.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope= rememberCoroutineScope()
            val pagerState= rememberPagerState(initialPage = 0)
            val  tabTitles = Commons.getTab()
            val tabIndex by remember { mutableStateOf(0) }
            BhumistarTheme {
                tabsWithSwiping(
                    pagerState = pagerState,
                    scope = scope,
                    tabIndex = tabIndex,
                    tabTitles = tabTitles,
                )
            }
        }
    }

}
