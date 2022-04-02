package com.digitalamanmedia.bhumistar.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun AddressField(
    height: Dp = 45.dp,
    width:Float = 1F,
    hint:String,
    singleLine:Boolean = true,
    text:String,
    onValueChanged:(String)->Unit
) {
    val darkTheme = isSystemInDarkTheme()
    val alpha = if (darkTheme){
        1f
    }else{
        0.04f
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(width)
    ){
        Text(
            text = hint,
            color = MaterialTheme.colors.primaryVariant.copy(alpha = 0.8f)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary.copy(alpha = alpha)),
            contentAlignment = Alignment.Center
        ){
            BasicTextField(
                modifier = Modifier
                    .border(0.dp,
                        shape = RoundedCornerShape(5.dp),
                        color = MaterialTheme.colors.error)
                    .fillMaxWidth()
                    .height(height)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                value = text,
                onValueChange = onValueChanged,
                textStyle = LocalTextStyle.current.copy(
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.primaryVariant.copy(alpha = 0.8f),
                    background = Color.Transparent
                ),
                singleLine = singleLine
            )
        }
    }

}