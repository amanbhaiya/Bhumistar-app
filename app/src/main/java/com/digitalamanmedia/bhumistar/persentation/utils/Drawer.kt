package com.digitalamanmedia.bhumistar.persentation.utils


import androidx.annotation.DrawableRes
import androidx.compose.animation.*
import androidx.compose.foundation.*
import com.digitalamanmedia.bhumistar.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.core.Commons
import com.digitalamanmedia.bhumistar.persentation.screens.profile.component.Dropdown
import com.digitalamanmedia.bhumistar.persentation.screens.profile.utils.StateAndDistrict

@Composable
fun NavigationDrawer(
    goToAuthentication:()->Unit,
    onItemClick:(String)->Unit
) {
    val scrollState = rememberScrollState()
    var isAuthVisible by remember {
        mutableStateOf(false)
    }
    var isCitiesVisible by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.13f)
            .background(MaterialTheme.colors.primary),
    )  {
        Row(
            modifier = Modifier
                .matchParentSize()
                .background(MaterialTheme.colors.primary)
                .padding(
                    horizontal = 25.dp,
                    vertical = 16.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image(
                painter = painterResource(
                    id = R.drawable.bhumistarjpg),
                contentDescription = "",
                modifier = Modifier
                    .clip(CircleShape)
                    .border(0.dp, MaterialTheme.colors.secondary, CircleShape)
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.padding(horizontal = 30.dp))
            Text(
                text = "Bhumistar",
                color = Color.White,
                fontSize = 26.sp
            )
        }
    }
    DrawerItems(
        img = R.drawable.sign,
        text = "Sign In",
        onDropDownClick = {
                          isAuthVisible = !isAuthVisible
        },
        isNeeded = true
    )
    AnimatedVisibility(
        visible = isAuthVisible,
        enter = fadeIn() + slideInVertically(),
        exit = fadeOut() + slideOutVertically()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        )  {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 70.dp,
                        vertical = 4.dp
                    )
                    .clickable {
                        goToAuthentication()
                    },
                text = "Register as Vendor",
                color = MaterialTheme.colors.primaryVariant,
                fontSize = 14.sp
            )
            Divider(
                modifier = Modifier
                    .width(200.dp)
                    .height(1.dp)
                    .padding(
                        start = 70.dp
                    )
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 70.dp,
                        vertical = 4.dp
                    )
                    .clickable {
                        goToAuthentication()
                    },
                text = "Register as User",
                color = MaterialTheme.colors.primaryVariant,
                fontSize = 14.sp
            )
            Divider(
                modifier = Modifier
                    .width(200.dp)
                    .height(1.dp)
                    .padding(
                        start = 70.dp
                    )
            )
        }
    }
    DrawerItems(
        img = R.drawable.icities,
        text = "Cities",
        onDropDownClick = {
            isCitiesVisible = !isCitiesVisible
        },
        isNeeded = true
    )
    AnimatedVisibility(
        visible = isCitiesVisible,
        enter = fadeIn() + slideInVertically(),
        exit = fadeOut() + slideOutVertically()
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 55.dp
            )
        ){
            Dropdown(
                list = StateAndDistrict.getState(),
                onClickItems = onItemClick,
                scrollState = scrollState,
                fontSize = 14.sp
            )
        }

    }
    DrawerItems(
        img = R.drawable.owner,
        text = "Owner Packages",
        onDropDownClick = {},
        isNeeded = false
    )
    DrawerItems(
        img = R.drawable.property_edge,
        text = "Property Edge",
        onDropDownClick = {},
        isNeeded = false
    )
    DrawerItems(
        img = R.drawable.buiyng_guide,
        text = "Buying Guide",
        onDropDownClick = {},
        isNeeded = false
    )
}

@Composable
fun DrawerItems(
    @DrawableRes img: Int,
    text: String,
    onDropDownClick:()-> Unit,
    isNeeded:Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onDropDownClick()
            }
            .background(MaterialTheme.colors.secondary)
        ,
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 16.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Icon(
                painter = painterResource(
                    id = img),
                contentDescription = text,
                tint = MaterialTheme.colors.primaryVariant
            )
            Spacer(modifier = Modifier.padding(horizontal = 16.dp))

            Text(
                text = text,
                color = MaterialTheme.colors.primaryVariant,
                fontSize = 15.sp
            )



        }
      if (isNeeded){
          IconButton(
              onClick = { onDropDownClick() },
              modifier = Modifier.align(CenterEnd)
          ) {
              Icon(
                  imageVector = Icons.Outlined.ArrowDropDown,
                  contentDescription = text,
                  tint = MaterialTheme.colors.primaryVariant
              )

          }
      }
    }


}