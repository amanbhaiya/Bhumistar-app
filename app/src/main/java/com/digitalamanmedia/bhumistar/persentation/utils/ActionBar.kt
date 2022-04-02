package com.digitalamanmedia.bhumistar.persentation.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.ui.theme.BadgeColor

@Composable
fun ActionBar(
    registerVendor:()->Unit
) {
     TopAppBar(
         modifier = Modifier
             .clip(
                 shape = RoundedCornerShape(
                     bottomStart = 5.dp,
                     bottomEnd = 5.dp
                 )
             ),
         backgroundColor = MaterialTheme.colors.primary,
         title = {
             Text(
                 text = "Bhumistar",
                 color = Color.White,
                 fontSize = 22.sp
             )
         },
         actions = {

             BadgedBox(
                 modifier = Modifier.padding(end = 40.dp),
                 badge ={
                     Badge( backgroundColor = BadgeColor) {
                         Text(
                             text = "FREE",
                             color = Color.White
                         )
                     }
                 }
             ) {
                 Text(
                     modifier = Modifier
                         .padding(top = 2.dp, end = 5.dp)
                         .clickable {
                             registerVendor()
                         },
                     text = "List Property",
                     color = Color.White,
                 )
             }

         }
     )
}
