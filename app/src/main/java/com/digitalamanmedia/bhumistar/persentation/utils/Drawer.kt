package com.digitalamanmedia.bhumistar.persentation.utils


import androidx.annotation.DrawableRes
import com.digitalamanmedia.bhumistar.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationDrawer() {
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
        onDropDownClick = {},
        isNeeded = true
    )
    DrawerItems(
        img = R.drawable.icities,
        text = "Cities",
        onDropDownClick = {},
        isNeeded = true
    )
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
    DrawerItems(
        img = R.drawable.about,
        text = "About Us",
        onDropDownClick = {},
        isNeeded = true
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
                fontSize = 16.sp
            )



        }
      if (isNeeded){
          IconButton(
              onClick = { onDropDownClick },
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