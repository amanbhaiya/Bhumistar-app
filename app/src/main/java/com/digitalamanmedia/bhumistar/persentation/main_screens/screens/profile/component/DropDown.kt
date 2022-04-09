package com.digitalamanmedia.bhumistar.persentation.main_screens.screens.profile.component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.*


@Composable
fun Dropdown(
    list: List<String>,
    onClickItems:(String)->Unit,
    scrollState: ScrollState,
    height:Dp = 300.dp,
    fontSize: TextUnit = 17.sp
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start= 15.dp,top=15.dp, end = 15.dp)
            .height(height)
            .verticalScroll(scrollState),
    ) {
        list.forEach { value->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onClickItems(value)
                    },
                text = value,
                color = MaterialTheme.colors.primaryVariant,
                fontSize = fontSize
            )
            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}