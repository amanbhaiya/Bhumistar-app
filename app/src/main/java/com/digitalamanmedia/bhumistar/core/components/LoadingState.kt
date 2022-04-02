package com.digitalamanmedia.bhumistar.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoadingState(
    modifier:Modifier = Modifier,
    fontSize:TextUnit = 18.sp,
    circleSize:Dp = 3.dp,
    travelDistance:Dp = 12.dp,
    spaceBetween:Dp = 5.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Loading",
            fontSize = fontSize,
            color = MaterialTheme.colors.error,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(end = 3.dp)

        )
        CircleLoadingState(
            circleSize = circleSize,
            spaceBetween = spaceBetween,
            travelDistance = travelDistance,
            modifier = Modifier.padding(top = 7.dp)
        )
    }
}