package com.digitalamanmedia.bhumistar.persentation.authentication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.MainActivity
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.persentation.authentication.user_auth.UserAuth
import com.digitalamanmedia.bhumistar.persentation.authentication.vendor_auth.VendorAuth

import com.digitalamanmedia.bhumistar.ui.theme.BhumistarTheme
import com.google.accompanist.pager.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@AndroidEntryPoint
class Authentication : ComponentActivity() {
    @ExperimentalComposeUiApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope= rememberCoroutineScope()
            val pagerState= rememberPagerState(initialPage = 0)
            val  tabTitles = Commons.getTab()
            var tabIndex by remember { mutableStateOf(0) }
            BhumistarTheme {
             tabsWithSwiping(
                 pagerState = pagerState,
                 scope = scope,
                 tabIndex = tabIndex,
                 tabTitles = tabTitles,
                 onSubmitClick = {
                     val i = Intent(this,MainActivity::class.java)
                     startActivity(i)
                     finish()
                 },
             )

            }
        }
    }

}
