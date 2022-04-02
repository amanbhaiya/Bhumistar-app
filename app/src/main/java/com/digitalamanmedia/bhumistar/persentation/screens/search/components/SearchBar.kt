package com.digitalamanmedia.bhumistar.persentation.screens.search.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.digitalamanmedia.bhumistar.ui.theme.YellowP


@Composable
fun SearchBar(
    text:String,
    onFocusChanged:(FocusState)->Unit,
    onValueChanged:(String)->Unit,
    onSearchClick:()->Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .border(0.dp, shape = CircleShape, color = MaterialTheme.colors.primaryVariant)
            .fillMaxWidth(0.86f)
            .height(45.dp),
            contentAlignment = Alignment.Center
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .onFocusChanged {onFocusChanged(it)},
                value = text,
                onValueChange = onValueChanged,
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.primaryVariant.copy(alpha = 0.8f),
                    background = Color.Transparent
                ),
                singleLine = true
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(
            onClick = onSearchClick
        ) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "",
                tint = MaterialTheme.colors.background,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.error)
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }
}
