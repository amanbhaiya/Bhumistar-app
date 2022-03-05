package com.digitalamanmedia.bhumistar.persentation.screens.profile.component

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Dropdown(
    hint: String,
    value: String,
    expanded:Boolean,
    onValueChanged: (String) -> Unit,
    onDropDownClick:()->Unit,
    list: List<String>,
    onClickItems:(String)->Unit,
    scrollState: ScrollState
) {
    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {
        ProfileTextField(
            value = value,
            onValueChanged = onValueChanged,
            onClearClick = onDropDownClick,
            icon = icon,
            hint = hint
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start= 15.dp,top=15.dp, end = 15.dp)
                .height(
                    if (expanded) 300.dp else 0.dp
                )
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
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Spacer(modifier = Modifier.height(16.dp))
            }


        }
    }
}