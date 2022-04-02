package com.digitalamanmedia.bhumistar.core.components

import androidx.compose.animation.core.*
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun CircleLoadingState(
    modifier: Modifier = Modifier,
    circleSize:Dp,
    circleColor:Color = MaterialTheme.colors.error,
    spaceBetween:Dp = 5.dp,
    travelDistance:Dp = 18.dp
){
    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )
    val circlesValue = circles.map {it.value}

    val distance = with(LocalDensity.current){travelDistance.toPx()}
    val lastCircle = circlesValue.size -1

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(key1 = animatable){
            delay(index * 100L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1200
                        0.0f at 0 with LinearOutSlowInEasing
                        1.0f at 300 with LinearOutSlowInEasing
                        0.0f at 600 with LinearOutSlowInEasing
                        0.0f at 1200 with LinearOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }
    
    Row(modifier = modifier) {
        circlesValue.forEachIndexed { i, value ->
            Box(
                modifier = modifier
                    .size(circleSize)
                    .graphicsLayer {
                        translationY = -value * distance
                    }
                    .background(
                        color = circleColor,
                        shape = CircleShape
                    )
            )
            if (i != lastCircle)(
                    Spacer(modifier = Modifier.width(spaceBetween))
            )
        }        
    }
}