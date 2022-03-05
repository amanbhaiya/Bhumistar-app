package com.digitalamanmedia.bhumistar.persentation.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.digitalamanmedia.bhumistar.persentation.navigation.NormalScreens.BottomNavScreens
import com.digitalamanmedia.bhumistar.ui.theme.BhumistarDark

@ExperimentalMaterialApi
@Composable
fun SearchScreen(navController: NavController) {
    val darkTheme = isSystemInDarkTheme()
    Box(modifier = Modifier
        .fillMaxSize().
        background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        if (darkTheme) {
            Image(

                painter = painterResource(id = com.digitalamanmedia.bhumistar.R.drawable.night_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)

            )
        } else {
            Image(

                painter = painterResource(id = com.digitalamanmedia.bhumistar.R.drawable.bhumistar),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)

            )
        }
    }


}


